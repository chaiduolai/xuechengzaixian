package com.xuecheng.api.course;

import com.xuecheng.framework.domain.course.CourseMarket;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @program: xcEduService01
 * @description: 课程营销接口
 * @author: Chai.duolai
 * @create: 2020-03-28 15:12
 **/
@Api(value = "课程营销接口",description = "课程营销接口的增删改查",tags = "课程营销")
public interface CourseMarketApi {
    @ApiOperation("获取课程营销信息")
    public CourseMarket getCourseMarketById(String courseId);
    @ApiOperation("更新课程营销信息")
    public ResponseResult updateCourseMarket(String id, CourseMarket courseMarket);
    
    
}
