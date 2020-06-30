package com.iupc;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

import javax.annotation.PostConstruct;
import java.util.TimeZone;


// 解决jmx重复注册bean的问题
@SpringBootApplication
@Import(FdfsClientConfig.class)
public class IupcApplication {


    public static void main(String[] args) {
        SpringApplication.run(IupcApplication.class, args);
    }

}
