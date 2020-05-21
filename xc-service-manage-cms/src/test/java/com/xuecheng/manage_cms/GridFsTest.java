package com.xuecheng.manage_cms;

/**
 * @program: xcEduService01
 * @description: GridFs测试类
 * @author: Chai.duolai
 * @create: 2020-03-12 16:17
 **/

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GridFsTest {
    @Autowired
    GridFsTemplate gridFsTemplate;
    @Autowired
    GridFSBucket gridFSBucket;
    @Test
    public void testGridFs() throws Exception {
        //要存储的文件
        File file=new File("D:\\course.ftl");
        //定义输入流
        FileInputStream inputStream=new FileInputStream(file);
        //向GridFs存储文件
        ObjectId objectId = gridFsTemplate.store(inputStream, "课程详情页面", "");
        String s = objectId.toString();
        System.out.println(s);
    }
    @Test
 public void queryFile() throws IOException {
    String fileId  = "5e6c8b977a3a1118ccf7c6dd";
 //根据id查询文件
     GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
      //打开下载流对象
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
 //创建gridFsResource，用于获取流对象
    GridFsResource gridFsResource = new GridFsResource(gridFSFile,gridFSDownloadStream);
   //获取流中的数据
    String s = IOUtils.toString(gridFsResource.getInputStream(), "UTF-8");
    System.out.println(s);
    }
}