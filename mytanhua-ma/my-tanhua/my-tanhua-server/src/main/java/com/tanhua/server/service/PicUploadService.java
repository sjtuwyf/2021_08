package com.tanhua.server.service;

import com.aliyun.oss.OSSClient;
import com.tanhua.server.config.AliyunConfig;
import com.tanhua.server.vo.PicUploadResult;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @Author ssqswyf
 * @Date 2021/8/20
 */
@Service
public class PicUploadService {

    private static final String[] IMAGE_TYPE = new String[]{".bmp",".jpg",".jpeg",".gif",".png"};

    @Autowired
    private OSSClient ossClient;

    @Autowired
    private AliyunConfig aliyunConfig;

    public PicUploadResult upload(MultipartFile uploadFile){
        PicUploadResult picUploadResult = new PicUploadResult();

        boolean isImage = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(), type)) {
                isImage = true;
            }
            break;

        }
        if (!isImage) {
            picUploadResult.setStatus("error");
            return picUploadResult;
        }

        String filename = uploadFile.getOriginalFilename();
        String filePath = getFilePath(filename);

        try {
            ossClient.putObject(aliyunConfig.getBucketName(), filePath,
                    new ByteArrayInputStream(uploadFile.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
            picUploadResult.setStatus("error");
            return  picUploadResult;
        }

        picUploadResult.setStatus("dong");
        picUploadResult.setName(this.aliyunConfig.getUrlPrefix()+filePath);
        picUploadResult.setUid(String.valueOf(System.currentTimeMillis()));

        return picUploadResult;
    }

    private String getFilePath(String sourceFileName) {
        DateTime dateTime = new DateTime();
        return "images/" + dateTime.toString("yyyy")
                + "/" + dateTime.toString("MM")
                + "/" + dateTime.toString("dd")
                + "/" + System.currentTimeMillis()
                + RandomUtils.nextInt(100, 9999)
                + "." + StringUtils.substringAfterLast(sourceFileName, ".");
    }
}
