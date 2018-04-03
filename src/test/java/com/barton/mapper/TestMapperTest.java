package com.barton.mapper;

import com.barton.dao.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 项目名称：ssm
 * 创建人：景荣荣
 * 创建时间： 2018-3-29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestMapperTest {
    @Autowired
    private TestMapper testMapper;
    @Test
    public void test1(){
        com.barton.domain.entity.Test test = testMapper.selectByPrimaryKey("1");
        System.out.print(test);
    }
}
