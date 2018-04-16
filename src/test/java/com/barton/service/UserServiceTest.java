package com.barton.service;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.barton.domain.entity.User;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;

/**
 * 项目名称：ssm
 * 创建人：景荣荣
 * 创建时间： 2018-4-15
 * 描述：UserService测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    private static final Log log = LogFactory.get();
    @Test
    public void selectByParams(){
        List<User> list = userService.selectByParams(new HashMap());
        System.out.println(list);

    }
}
