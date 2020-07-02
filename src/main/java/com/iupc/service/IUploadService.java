package com.iupc.service;

import com.iupc.pojo.News;
import com.iupc.pojo.NewsPic;

import com.iupc.pojo.Notes;
import com.iupc.pojo.Users;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public interface IUploadService {
    public HashMap<String,String> upload_news(MultipartFile[] files,MultipartFile file,News news) throws IOException;
    public HashMap<String,String> upload_note(MultipartFile[] files, MultipartFile file, Notes note) throws IOException;
    public HashMap<String,String> upload_user(MultipartFile file, Users user) throws IOException;

}
