package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.system.SysDictionary;
import com.xuecheng.manage_cms.dao.SysDicthinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: xcEduService01
 * @description:
 * @author: Chai.duolai
 * @create: 2020-03-24 17:18
 **/
@Service
public class SysDicthinaryService {
    @Autowired
    SysDicthinaryRepository sysDicthinaryRepository;
    public SysDictionary getDictionaryByType(String dType) {
        SysDictionary byType = sysDicthinaryRepository.findBydType(dType);
        return byType;
    }
}