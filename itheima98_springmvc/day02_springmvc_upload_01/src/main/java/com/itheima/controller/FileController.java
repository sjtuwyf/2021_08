package com.itheima.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @Author ssqswyf
 * @Date 2021/8/7
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @PostMapping("/upload")
    public String upload(String pdesc, MultipartFile upload, HttpServletRequest request) {
        System.out.println("pdesc" + pdesc);

        String realPath = request.getSession().getServletContext().getRealPath("file");

        File file = new File(realPath);

        if (!file.exists()) {
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        try {
            upload.transferTo(new File(file,filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";
    }

}
