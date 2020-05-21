package com.xuecheng.manage_course.service;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import com.xuecheng.manage_course.dao.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: xcEduService01
 * @description: 课程分类
 * @author: Chai.duolai
 * @create: 2020-03-24 15:39
 **/
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    //查询课程分类
    public CategoryNode findCategoryList(){
        return categoryMapper.findList();
    }
}