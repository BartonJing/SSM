package com.barton.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.druid.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 项目名称：ssm
 * dashboard
 */
@Controller
public class DashboardController {
    private static final Log logger = LogFactory.get();
    @GetMapping(value = {"/dashboard"})
    public String index() {
        return "/dashboard/index";
    }
}
