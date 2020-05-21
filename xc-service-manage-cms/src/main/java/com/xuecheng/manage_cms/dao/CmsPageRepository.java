package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @program: xcEduService01
 * @description: 页面信息dao层
 * @author: Chai.duolai
 * @create: 2020-02-27 15:42
 **/
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {
    //根据页面名称、站点id、页面访问路径查询
    CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName,String siteId,String pageWebPath);
}
