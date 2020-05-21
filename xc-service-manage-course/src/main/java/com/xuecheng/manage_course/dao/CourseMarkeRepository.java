package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.CourseMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: xcEduService01
 * @description: 课程营销接口
 * @author: Chai.duolai
 * @create: 2020-03-28 15:20
 **/
@Repository
public interface CourseMarkeRepository extends JpaRepository<CourseMarket,String>{
}
