package com.iupc.service;

import com.iupc.pojo.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface IUploadService {
    public HashMap<String,String> upload_news(MultipartFile[] files,MultipartFile file,News news) throws IOException;
    public HashMap<String,String> upload_note(MultipartFile[] files, MultipartFile file, Notes note) throws IOException;
    public HashMap<String,String> upload_user(MultipartFile file, Users user) throws IOException;
    public HashMap<String,String> upload_goods(MultipartFile[] files, MultipartFile file, Goods good, List<Goods_num> goods_num) throws IOException;

}
