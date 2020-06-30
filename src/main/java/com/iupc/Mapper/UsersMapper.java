package com.iupc.Mapper;

import com.iupc.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UsersMapper {
    Users getUserByName(Users user);

}
