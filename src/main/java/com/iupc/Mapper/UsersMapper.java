package com.iupc.Mapper;

import com.iupc.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UsersMapper {
    void updateUserRole(Users users);
    Users getUserByName(String username);
    Shop getShopByName(String username);
    void insertUsers(Users user);
    void insertFover(FavoriteContent fc);
    int getIdtoSet();
    void insertDiscuss(DiscussContent discussContent);
    List<DiscussContent> getDiscussBytoid(String answerto);
    Shop qurryShopById(String id);
    void insertShop(Shop shop);
    int getMaxShopid();
    void updateTimes(Record record);
    void  insertRecord(Record record);
    Record qurryRecordBynk(String username,String keys);

    String[] qurryRecordByusername(String username);
}
