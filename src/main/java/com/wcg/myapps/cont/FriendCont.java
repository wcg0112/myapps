package com.wcg.myapps.cont;

import com.wcg.myapps.mapper.FriendEntity;
import com.wcg.myapps.mapper.FriendsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class FriendCont {
    @Autowired
    FriendsDAO fdao;
    @GetMapping("/api/getfriend")
    public List<FriendEntity> getFriends() {
        List<FriendEntity> fList = fdao.friendList();
        Logger logger = Logger.getLogger("FriendCont");
        logger.info("RESULT : " + fList.toString());;
        return fList;
    }

    @GetMapping("/api/insertfriend")
    public String insertFriends() {
        Long maxId = fdao.selectMaxId();
        Logger logger = Logger.getLogger("FriendCont");
        logger.info("RESULT : " + maxId);;

        FriendEntity e = new FriendEntity();
        e.setId(maxId);
        e.setName("changki"+maxId);
        e.setAge(39);
        e.setGender("M");

        int result =fdao.insertFriend(e);
        if(result > 0) {
            return "SUCCESS : updated row count :" + result;
        }
        else {
            throw new RuntimeException();
        }
    }
}
