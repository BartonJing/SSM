package com.barton.service;

/**
 * 项目名称：ssm
 * 创建人：景荣荣
 * 创建时间： 2018-4-9
 * 描述：公共Service接口
 */
public interface BaseService<T> {
    /**
     * 新增实体
     *
     * @param t
     * @return
     */
    T insert(T t);

    /**
     * 修改实体
     *
     * @param t
     * @return
     */
    T update(T t);
}
