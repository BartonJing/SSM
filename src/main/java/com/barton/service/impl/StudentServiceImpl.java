package com.barton.service.impl;

import com.barton.dao.StudentMapper;
import com.barton.domain.entity.Student;
import com.barton.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by barton on 2018-7-4
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Student insert(Student student) {
        if(studentMapper.insertSelective(student) > 0){
            return student;
        }
        return null;
    }

    @Override
    public Student update(Student student) {
        if(studentMapper.updateByPrimaryKeySelective(student) > 0){
            return student;
        }
        return null;
    }
}
