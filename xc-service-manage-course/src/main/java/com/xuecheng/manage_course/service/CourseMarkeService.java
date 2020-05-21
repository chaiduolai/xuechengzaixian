package com.xuecheng.manage_course.service;

import com.xuecheng.framework.domain.course.CourseMarket;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_course.dao.CourseMarkeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @program: xcEduService01
 * @description: 课程营销处理层
 * @author: Chai.duolai
 * @create: 2020-03-28 15:22
 **/
@Service
public class CourseMarkeService {
    @Autowired
    private CourseMarkeRepository courseMarkeRepository;
    
    /**
     * 根据课程id查询课程营销信息
     * @param courseId
     * @return
     */
    public CourseMarket findById(String courseId) {
        Optional<CourseMarket> optional = courseMarkeRepository.findById(courseId);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
    
    /**
     * 修改课程营销
     * @param id
     * @param courseMarket
     * @return
     */
    @Transactional
    public ResponseResult updateCourseMarket(String id, CourseMarket courseMarket) {
        CourseMarket market = this.findById(id);
        if (market ==null){
            courseMarkeRepository.save(courseMarket);
            return new ResponseResult(CommonCode.SUCCESS);
        }else {
            courseMarkeRepository.save(courseMarket);
            return new ResponseResult(CommonCode.SUCCESS);
        }
    }
}