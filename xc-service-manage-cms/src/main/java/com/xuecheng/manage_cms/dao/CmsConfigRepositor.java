package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @program: xcEduService01
 * @description: CmsConfig的dao接口
 * @author: Chai.duolai
 * @create: 2020-03-12 14:02
 **/
public interface CmsConfigRepositor extends MongoRepository<CmsConfig,String> {
}
