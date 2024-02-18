package com.itcast.controller;

import com.itcast.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/24 15:59
 * @Version: 1.0
 * @Description:
 */
@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
//        保证文件名字是唯一的，从而防止文件覆盖
        String filename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        file.transferTo(new File("E:\\SpringBoot开发\\HeiMaBigEvent\\img\\"+filename));
        return Result.success("url访问地址...");
    }
}
