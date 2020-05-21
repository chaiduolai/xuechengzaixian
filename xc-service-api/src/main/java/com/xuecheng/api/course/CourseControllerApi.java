package com.xuecheng.api.course;

import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.CoursePic;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.ext.CourseView;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.domain.course.response.CoursePublishResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @program: xcEduService01
 * @description: 课程管理接口
 * @author: Chai.duolai
 * @create: 2020-03-20 17:51
 **/
@Api(value="课程管理接口",description = "课程管理接口，提供课程的增删改查")
public interface CourseControllerApi {
    @ApiOperation("课程计划查询")
    public TeachplanNode findTeachplanList(String courseId);
    @ApiOperation("添加课程计划")
    public ResponseResult addTeachplan(Teachplan teachplan);
    @ApiOperation("查询我的课程列表")
    public QueryResponseResult findCourseList(int page, int size, CourseListRequest courseListRequest);
    @ApiOperation("添加课程")
    public ResponseResult addCourseBase(CourseBase courseBase);
    @ApiOperation("根据id查询课程信息")
    public CourseBase findCourseBaseInfoById(String courseId);
    @ApiOperation("更新课程基础信息")
    public ResponseResult updateCourseBase(String id,CourseBase courseBase);
    @ApiOperation("添加课程图片")
    public ResponseResult addCoursePic(String courseId,String pic);
    @ApiOperation("获取课程基础信息")
    public CoursePic findCoursePic(String courseId);
    @ApiOperation("删除课程图片")
    public ResponseResult deleteCoursePic(String courseId);
    
    /**
     * 课程视图查询
     * @param id
     * @return
     */
    @ApiOperation("课程视图查询")
    public CourseView courseview(String id);
    @ApiOperation("预览课程")
    public CoursePublishResult preview(String id);
    
}
