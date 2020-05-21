package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: xcEduService01
 * @description: 课程分类
 * @author: Chai.duolai
 * @create: 2020-03-22 16:47
 **/
@Mapper
public interface CategoryMapper {
    public CategoryNode findList();
    
}
