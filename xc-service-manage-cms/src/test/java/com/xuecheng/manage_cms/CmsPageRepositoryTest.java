package com.xuecheng.manage_cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

/**
 * @program: xcEduService01
 * @description: 页面接口测试
 * @author: Chai.duolai
 * @create: 2020-02-27 15:43
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private CmsPageRepository cmsPageRepository;
    @Test
    //分页查询
    public void testFindPage(){
        int page=0;
        int size=10;
        Pageable pageable= PageRequest.of(page,size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);
    }
//    @Test
//    public void testUpdate() {
    /*Optional<CmsPage> optional = cmsPageRepository.findOne("5b17a34211fe5e2ee8c116c9");
    if(optional.isPresent()){
    CmsPage cmsPage = optional.get();
    cmsPage.setPageName("测试页面01");
    cmsPageRepository.save(cmsPage);
        }
    }*/
    @Test
    public void testRestTemplate(){
    ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f", Map.class);
        Map body = forEntity.getBody();
        System.out.println(body);
    }
}