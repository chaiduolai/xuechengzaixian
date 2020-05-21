/*
package com.xuecheng.test.freemarker;

import com.sun.corba.se.spi.ior.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;*
 */
/* @program: xcEduService01
 * @description: GridFs测试类
 * @author: Chai.duolai
 * @create: 2020-03-12 16:17
 *//*

 
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GridFsTest {
    @Autowired
//    GridFsTemplate gridFsTemplate;
    @Test
    public void testGridFs() throws Exception {
        //要存储的文件
        File file=new File("D:\\index_banner.ftl");
        //定义输入流
        FileInputStream inputStream=new FileInputStream(file);
        //向GridFs存储文件
        ObjectId objectId = gridFsTemplate.store(inputStream, "轮播图测试文件01", "");
        String s = objectId.toString();
        System.out.println(file);
    
    
    }
}
*/
