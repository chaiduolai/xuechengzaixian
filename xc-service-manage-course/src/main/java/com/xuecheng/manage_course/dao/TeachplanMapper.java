package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: xcEduService01
 * @description: 课程计划持久层
 * @author: Chai.duolai
 * @create: 2020-03-21 14:26
 **/
@Mapper
public interface TeachplanMapper {
    public TeachplanNode selectList(String courseId);
}
