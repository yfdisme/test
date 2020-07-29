//package com.test.mytest.controller;
//
//
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import net.lingala.zip4j.ZipFile;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.Charset;Charset
//
//
//@RestController
//public class Zip4Utils {
//
//    @ApiOperation(value = "上传zip文件",notes = "上传文件")
//    @PostMapping(value = "/upload/zip")
//    public String uploadFile(@ApiParam(name = "zipFile",value = "上传文件",required = true) MultipartFile zipFile) throws IOException {
//        String zipFilename = zipFile.getOriginalFilename();
//        String path = "D:\\download";
//        File file = new File(path+"\\"+zipFilename);
//        if (!file.getParentFile().exists()){
//            file.getParentFile().mkdirs();
//        }
//
//        zipFile.transferTo(file);
//
//        ZipFile zFile1 = new ZipFile(file);
//
//        String dest = "D:\\download\\Extract";
//        File destdir = new File(dest);
//        zFile1.extractAll(dest);
//        return "succ";
//    }
//
//
//}
