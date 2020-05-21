package com.xuecheng.framework.domain.course.ext;

import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.CourseMarket;
import com.xuecheng.framework.domain.course.CoursePic;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @program: xcEduService01
 * @description: 课程视图实例
 * @author: Chai.duolai
 * @create: 2020-04-01 20:29
 **/
@Data
@ToString
@NoArgsConstructor //无参构造方法
public class CourseView implements Serializable {
    
    private static final long serialVersionUID = 1955897188369959832L;
    /**
     *课程基本信息
     */
    private CourseBase courseBase;
    /**
     * 课程营销消息
     */
    private CourseMarket courseMarket;
    /**
     * 课程价格
     */
    private CoursePic coursePic;
    /**
     * 课程计划
     */
    private TeachplanNode teachplanNode;
}