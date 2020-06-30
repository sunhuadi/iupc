package com.iupc.service;

import com.iupc.pojo.News;
import com.iupc.pojo.NewsPic;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public interface IUploadService {
    public HashMap<String,String> upload_news(MultipartFile[] files,MultipartFile file,News news) throws IOException;

}
