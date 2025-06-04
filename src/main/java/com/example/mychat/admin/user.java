package com.example.mychat.admin;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.ArrayList;
@Document(collection = "users")// MongoDB collection name
public class user {
    @Id
   private String userID;
   private String username;
   private String password;
   private List<String> friendList= new ArrayList<>();

    public user(Long String, String username, String password) {


        this.userID= userID;
        this.username= username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



    public String getUserID(){
        return userID;
    }
    public void setUserID(String userID){
        this.userID=userID;
    }


    public void setFriendList(List<String> friendList){
        this.friendList=friendList;
    }
    public List<String> getFriendList(){
        return friendList;
    }
    public void addFriend(String friend){
        friendList.add(friend);
    }
    public void removeFriend(String Friend){
        friendList.remove(Friend);
    }
}
