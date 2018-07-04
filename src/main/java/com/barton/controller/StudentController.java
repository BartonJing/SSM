package com.barton.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.barton.common.ServerResponse;
import com.barton.domain.entity.Student;
import com.barton.service.StudentService;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.beans.Transient;
import java.util.Date;
import java.util.UUID;

/**
 * 项目名称：ssm
 * 登陆
 */
@Controller
public class StudentController {
    private static final Log logger = LogFactory.get();
@Autowired
private StudentService studentService;
    @GetMapping("/login")
    public String doLogin(Model model) {
        model.addAttribute("student",new Student());
        return "/dashboard/student/index";
    }
    @PostMapping("/student/doAdd")
    @ResponseBody
    @Transient
    public ServerResponse doAdd(@RequestBody Student student) {
        if(student == null){
            return ServerResponse.createByErrorMessage("请填写信息");
        }
        if(StringUtils.isEmpty(student.getId())){
            student.setId(RandomUtil.randomUUID());
            student.setCreateDate(new Date());
            studentService.insert(student);
        }else{
            studentService.update(student);
        }
        return ServerResponse.createBySuccess("保存成功，感谢您的参与。祝您生活愉快，工作顺利！！！",student);
    }
}
/*
*
*
set @rownum=0;
select
 @rownum:=@rownum+1 as '序号',
name as '姓名',
sex as '姓别',
end_date as '毕业时间',
profession as '专业',
company as '现工作单位名称',
address as '单位地址',
tele as '联系方式',
qq as 'QQ',
email as '邮箱',
remark as '备注'

 from student
* */