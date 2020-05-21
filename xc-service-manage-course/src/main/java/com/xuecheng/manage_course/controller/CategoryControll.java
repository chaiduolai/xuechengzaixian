package com.xuecheng.manage_course.controller;

import com.xuecheng.api.course.CategoryControllerApi;
import com.xuecheng.framework.domain.course.ext.CategoryNode;
import com.xuecheng.manage_course.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: xcEduService01
 * @description: 课程分类管理
 * @author: Chai.duolai
 * @create: 2020-03-22 16:38
 **/
@RestController
@RequestMapping("/category")
public class CategoryControll implements CategoryControllerApi {
    @Autowired
    private CategoryService categoryService;
    @Override
    @GetMapping("/list")
    public CategoryNode findList() {
        return categoryService.findCategoryList();
    }
}