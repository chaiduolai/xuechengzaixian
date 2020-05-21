package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.system.SysDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @program: xcEduService01
 * @description: 字典
 * @author: Chai.duolai
 * @create: 2020-03-24 17:19
 **/
public interface SysDicthinaryRepository extends MongoRepository<SysDictionary,String> {
    public SysDictionary findBydType(String dType);
}
