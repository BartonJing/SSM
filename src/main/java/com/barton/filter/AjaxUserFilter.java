package com.barton.filter;

import com.barton.common.ResponseCode;
import com.barton.common.ServerResponse;
import com.barton.utils.ResponseJsonUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Component
public class AjaxUserFilter extends UserFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws Exception {

        HttpServletRequest req = WebUtils.toHttp(request);
        HttpServletResponse res = WebUtils.toHttp(response);

        Subject subject = getSubject(req, res);
        if (subject.getPrincipal() == null) {
            if (isAjax(req)) {
                ResponseJsonUtils.json(res, ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc()));
            } else {
                saveRequestAndRedirectToLogin(req, res);
            }
            return false;

        } else {
            if (isAjax(req)) {
                ResponseJsonUtils.json(res, ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_PERMISSION.getCode(), ResponseCode.NEED_PERMISSION.getDesc()));
                return false;
            }
        }


        return super.onAccessDenied(request, response);
    }

    /**
     * 判断ajax请求
     *
     * @param request
     * @return
     */
    boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null && "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
}
