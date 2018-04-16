package com.barton.controller;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.level.Level;
import com.barton.domain.entity.User;
import com.barton.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * 创建人：景荣荣
 * 创建时间： 2018-4-15
 */
@Controller
@RequestMapping("/dashboard/user")
public class UserController {
    private static final Log log = LogFactory.get();
    @Autowired
    private UserService userService;

    @ApiOperation(value="测试redis缓存", notes="测试redisController")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/test")
    @ResponseBody
    public String select(){
        List<User> userList = userService.selectByParams(new HashMap<>());
        System.out.println(userList);
        return "/dashboard/test/test";
    }

}
