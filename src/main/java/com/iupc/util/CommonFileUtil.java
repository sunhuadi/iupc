package com.iupc.util;

import com.github.tobato.fastdfs.domain.MataData;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.iupc.config.FdfsConfig;
import org.apache.commons.io.FilenameUtils;
import org.csource.fastdfs.StorageClient1;
import org.eclipse.jetty.http.MetaData;
import org.omg.CORBA.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Set;

@Component
public class CommonFileUtil {

    private final Logger logger = LoggerFactory.getLogger(FdfsConfig.class);

    @Autowired
    private FastFileStorageClient storageClient;



    /**
     *	MultipartFile类型的文件上传ַ
     * @param file
     * @return
     * @throwsIOException
     */
    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(),
                FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return getResAccessUrl(storePath);
    }

    /**
     * 普通的文件上传
     *
     * @param file
     * @return
     * @throws IOException
     */
    StorageClient1  storageClient1;
    public String uploadFile(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
       StorePath path = storageClient.uploadFile(inputStream, file.length(),
                FilenameUtils.getExtension(file.getName()), null);
        return getResAccessUrl(path);
    }

    public String uploadFileStream(InputStream is, long size, String fileName) {
        StorePath path = storageClient.uploadFile(is, size, fileName, null);
        return getResAccessUrl(path);
    }

    /**
     * 将一段文本文件写到fastdfs的服务器上
     *
     * @paramontent
     * @paramfileExtension
     * @return
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath path = storageClient.uploadFile(stream, buff.length, fileExtension, null);//上传
        String s=path.getFullPath();
        Set<MataData> matadata1 = storageClient.getMetadata(path.getGroup(),path.getPath());
        System.out.println(matadata1);
        return getResAccessUrl(path);
    }
    /**
     * 返回文件上传成功后的地址名称ַ
     * @param storePath
     * @return
     */
    private String getResAccessUrl(StorePath storePath) {
        String fileUrl = storePath.getFullPath();
        return fileUrl;
    }

    /**
     * 删除文件
     * @param
     */
    public void deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return;
        }
        try {
            StorePath storePath = StorePath.praseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {
            logger.warn(e.getMessage());
        }
    }
    public String upfileImage(InputStream is, long size, String fileExtName, Set<MataData> mataData) {
        StorePath path = storageClient.uploadImageAndCrtThumbImage(is, size, fileExtName,mataData);
        return getResAccessUrl(path);
    }

}
