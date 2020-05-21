package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsConfig;
import com.xuecheng.manage_cms.dao.CmsConfigRepositor;
import org.bouncycastle.cms.CMSConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @program: xcEduService01
 * @description: cmsconfig业务处理层
 * @author: Chai.duolai
 * @create: 2020-03-12 14:03
 **/
@Service
public class CmsConfigService {
    @Autowired
    private CmsConfigRepositor cmsConfigRepositor;
    public CmsConfig getConfigById(String id){
        Optional<CmsConfig> option = cmsConfigRepositor.findById(id);
        if (option.isPresent()){
            CmsConfig cmsConfig = option.get();
            return  cmsConfig;
        }
        return null;
    }
}