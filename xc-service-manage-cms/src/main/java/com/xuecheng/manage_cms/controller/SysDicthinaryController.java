package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.SysDicthinaryControllerApi;
import com.xuecheng.framework.domain.system.SysDictionary;
import com.xuecheng.manage_cms.service.SysDicthinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: xcEduService01
 * @description: 数据字典
 * @author: Chai.duolai
 * @create: 2020-03-24 16:43
 **/
@RestController
@RequestMapping("/sys/dictionary")
public class SysDicthinaryController implements SysDicthinaryControllerApi {
    @Autowired
    private SysDicthinaryService sysDicthinaryService;
    @Override
    @GetMapping("/get/{dType}")
    public SysDictionary getByType(@PathVariable("dType") String dType) {
        return sysDicthinaryService.getDictionaryByType(dType);
    }
}