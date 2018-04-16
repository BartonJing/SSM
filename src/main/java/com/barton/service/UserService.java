package com.barton.service;

import com.barton.domain.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 创建人：景荣荣
 * 创建时间： 2018-4-2
 * 描述：
 */
public interface UserService extends BaseService<User>{
    List<User> selectByParams(Map<String,Object> params);
}
