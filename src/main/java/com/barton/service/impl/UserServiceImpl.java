package com.barton.service.impl;

import com.barton.dao.UserMapper;
import com.barton.domain.entity.User;
import com.barton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 项目名称：ssm
 * 创建人：景荣荣
 * 创建时间： 2018-4-9
 * 描述：用户Service实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @CachePut(key = "#p0.id",value="user")
    public User insert(User user) {
        if(userMapper.insertSelective(user) > 0){
            return user;
        }
        return null;
    }

    @Override
    @CachePut(key="#p0.id",value="user")
    public User update(User user) {
        if(userMapper.updateByPrimaryKeySelective(user) > 0){
            return user;
        }
        return null;
    }

    @Override
    @Cacheable(value="selectByParams")
    public List<User> selectByParams(Map<String, Object> params) {
        return userMapper.selectByParams(params);
    }
}
