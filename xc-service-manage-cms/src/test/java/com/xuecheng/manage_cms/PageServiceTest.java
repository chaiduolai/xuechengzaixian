package com.xuecheng.manage_cms;

/**
 * @program: xcEduService01
 * @description: 页面测试类
 * @author: Chai.duolai
 * @create: 2020-03-13 14:43
 **/

import com.xuecheng.manage_cms.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PageServiceTest {
    @Autowired
    PageService pageService;
    @Test
    public void gehtml(){
        String pageHtml = pageService.getPageHtml("5e6b25941e8e8d2dec6f5d66");
        System.out.println(pageHtml);
    }
}