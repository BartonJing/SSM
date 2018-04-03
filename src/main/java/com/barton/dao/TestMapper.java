package com.barton.dao;

import com.barton.domain.entity.Test;

public interface TestMapper {
    /**
     *
     * @mbggenerated 2018-03-29
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-03-29
     */
    int insert(Test record);

    /**
     *
     * @mbggenerated 2018-03-29
     */
    int insertSelective(Test record);

    /**
     *
     * @mbggenerated 2018-03-29
     */
    Test selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated 2018-03-29
     */
    int updateByPrimaryKeySelective(Test record);

    /**
     *
     * @mbggenerated 2018-03-29
     */
    int updateByPrimaryKey(Test record);
}