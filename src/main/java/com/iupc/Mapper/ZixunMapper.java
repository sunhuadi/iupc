package com.iupc.Mapper;

import com.iupc.pojo.zixun;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ZixunMapper {
    List <zixun> qurryzixunall();

}
