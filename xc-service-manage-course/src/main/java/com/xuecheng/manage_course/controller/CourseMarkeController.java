package com.xuecheng.manage_course.controller;

import com.xuecheng.api.course.CourseMarketApi;
import com.xuecheng.framework.domain.course.CourseMarket;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_course.service.CourseMarkeService;
import com.xuecheng.manage_course.service.CourseService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: xcEduService01
 * @description: 课程营销API
 * @author: Chai.duolai
 * @create: 2020-03-28 15:14
 **/
@RestController
@RequestMapping("/courseMarket")
public class CourseMarkeController implements CourseMarketApi {
    @Autowired
    private CourseMarkeService courseMarkeService;
    //根据id查询课程营销计划
    @Override
    @GetMapping("/findById/{courseId}")
    public CourseMarket getCourseMarketById(@ApiParam(name = "courseId",value = "课程id") @PathVariable("courseId") String courseId) {
        return courseMarkeService.findById(courseId);
    }
    
    /**
     * 修改课程营销计划内容
     * @param id
     * @param courseMarket
     * @return
     */
    @Override
    @PutMapping("/updateCourseMarket/{id}")
    public ResponseResult updateCourseMarket(@PathVariable("id") String id,@RequestBody CourseMarket courseMarket) {
       return courseMarkeService.updateCourseMarket(id,courseMarket);
    }
}