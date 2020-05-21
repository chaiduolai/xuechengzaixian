package com.xuecheng.filesystem.service;

import com.alibaba.fastjson.JSON;
import com.xuecheng.filesystem.dao.FileSystemRepository;
import com.xuecheng.framework.domain.filesystem.FileSystem;
import com.xuecheng.framework.domain.filesystem.response.FileSystemCode;
import com.xuecheng.framework.domain.filesystem.response.UploadFileResult;
import com.xuecheng.framework.exception.ExceptionCast;
import com.xuecheng.framework.model.response.CommonCode;
import org.apache.commons.lang3.StringUtils;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @program: xcEduService01
 * @description: 文件管理业务逻辑层
 * @author: Chai.duolai
 * @create: 2020-03-30 15:47
 **/
@Service
public class FileSystemService {
    private static final Logger LOGGER= LoggerFactory.getLogger(FileSystemService.class);
    @Autowired
    private FileSystemRepository fileSystemRepository;
    //读取配置文件的信息
    @Value("${xuecheng.fastdfs.tracker_servers}")
    String tracker_servers;
    @Value("${xuecheng.fastdfs.connect_timeout_in_seconds}")
    int connect_timeout_in_seconds;
    @Value("${xuecheng.fastdfs.network_timeout_in_seconds}")
    int network_timeout_in_seconds;
    @Value("${xuecheng.fastdfs.charset}")
    String charset;
    @Transactional
    public UploadFileResult upload(MultipartFile file,String filetag, String businesskey, String metadata){
        if (file ==null){
            ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_FILEISNULL);
        }
        //上传文件到fdfs
        String fileId=fdfs_upload(file);
        if (StringUtils.isEmpty(fileId)){
            ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_SERVERFAIL);
        }
        //将文件信息保存到文件数据库
        //创建文件信息对象
        FileSystem fileSystem = new FileSystem();
//文件id
        fileSystem.setFileId(fileId);
//文件在文件系统中的路径
        fileSystem.setFilePath(fileId);
//业务标识
        fileSystem.setBusinesskey(businesskey);
//标签
        fileSystem.setFiletag(filetag);
//元数据
        if(StringUtils.isNotEmpty(metadata)){
            try {
                Map map = JSON.parseObject(metadata, Map.class);
                fileSystem.setMetadata(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//名称
        fileSystem.setFileName(file.getOriginalFilename());
//大小
        fileSystem.setFileSize(file.getSize());
//文件类型
        fileSystem.setFileType(file.getContentType());
        fileSystem = fileSystemRepository.save(fileSystem);
        LOGGER.info("图片保存成功");
        return new UploadFileResult(CommonCode.SUCCESS,fileSystem);
    }
    
    /**
     * 上传文件到fastDFS 返回文件ID
     * @param file
     * @return
     */
    private String fdfs_upload(MultipartFile file) {
        try {
            //首先加载dfs的配置
            initFdfsConfig();
            //创建tracker client
            TrackerClient trackerClient=new TrackerClient();
            //获取trackerServer
            TrackerServer trackerServer = trackerClient.getConnection();
            //获取storage
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            //创建storage client
            StorageClient1 storageClient1=new StorageClient1(trackerServer,storageServer);
            //上传文件
            //获取文件字节
            byte[] fileBytes = file.getBytes();
            //获取文件原始名称
            String filename = file.getOriginalFilename();
            //获取文件扩展名
            String extName = filename.substring(filename.lastIndexOf(".") + 1);
            String fileId = storageClient1.upload_appender_file1(fileBytes, extName, null);
            return fileId;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //加载dfs的配置
    private void initFdfsConfig() {
        try {
            //加载跟踪服务器ip
            ClientGlobal.initByTrackers(tracker_servers);
            //设置超时时间
            ClientGlobal.setG_connect_timeout(connect_timeout_in_seconds);;
            ClientGlobal.setG_network_timeout(network_timeout_in_seconds);
            //设置字符集
            ClientGlobal.setG_charset(charset);
        }
        catch (Exception e) {
            //初始化文件系统出错
            ExceptionCast.cast(FileSystemCode.FS_INITFDFSERROR);
            e.printStackTrace();
        }
    
    }
}