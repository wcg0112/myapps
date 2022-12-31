package com.wcg.myapps.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FriendsDAO {
    public List<FriendEntity> friendList();

    public Long selectMaxId();

    public int insertFriend(FriendEntity e);
}
