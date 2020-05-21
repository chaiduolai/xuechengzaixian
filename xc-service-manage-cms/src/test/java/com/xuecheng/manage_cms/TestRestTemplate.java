package com.xuecheng.manage_cms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @program: xcEduService01
 * @description: 数据模型测试类
 * @author: Chai.duolai
 * @create: 2020-03-14 14:46
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRestTemplate {
    @Autowired
    RestTemplate restTemplate;
    @Test
    public void testRestmeplate(){
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f", Map.class);
        Map body = forEntity.getBody();
        System.out.println(forEntity);
    }
}