package com.xuecheng.filesystem.dao;

import com.xuecheng.framework.domain.filesystem.FileSystem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: xcEduService01
 * @description: 文件管理持久层
 * @author: Chai.duolai
 * @create: 2020-03-30 15:46
 **/
@Repository
public interface FileSystemRepository extends MongoRepository<FileSystem,String> {
}
