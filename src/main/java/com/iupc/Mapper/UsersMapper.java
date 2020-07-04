package com.iupc.Mapper;

import com.iupc.pojo.DiscussContent;
import com.iupc.pojo.FavoriteContent;
import com.iupc.pojo.Shop;
import com.iupc.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UsersMapper {
    Users getUserByName(String username);
    Shop getShopByName(String username);
    void insertUsers(Users user);
    void insertFover(FavoriteContent fc);
    int getIdtoSet();
    void insertDiscuss(DiscussContent discussContent);
    List<DiscussContent> getDiscussBytoid(String answerto);
    Shop qurryShopById(String id);
}
