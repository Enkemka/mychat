package com.example.mychat.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userService {
    private final userRepository UserRepository;

    @Autowired
    public userService(userRepository UserRepository) {
        this.UserRepository = UserRepository;
    }


    //get all
    public List<user> getAllUsers() {
        return UserRepository.findAll();
    }

    //getbyid
    public Optional<user> getUserById(String Id) {
        Optional<user> foundUser = UserRepository.findById(Id);
        if (foundUser.isPresent()) {
            user newUser = foundUser.get();
            return foundUser;
            //
        }
        return foundUser;
    }

    //post(new)
    public user saveUser(user User) {
        return UserRepository.save(User);
    }

    //put (update
    public user updateUser(String Id, user User) {
        Optional<user> optionalUser = UserRepository.findById(Id);
        if (optionalUser.isPresent()) {
            user updatedUser = optionalUser.get();

            updatedUser.setUserID(User.getUserID());
            updatedUser.setPassword(User.getPassword());
            updatedUser.setFriendList(User.getFriendList());
            updatedUser.setUsername(User.getUsername());

            return UserRepository.save(updatedUser);
        }
        return UserRepository.save(User);
        //fix this
    }

//patch


    //  delete
    public void deleteById(String Id) {
        UserRepository.deleteById(Id);
    }


    public void deleteByMsgId(String Id) {
        UserRepository.deleteById(Id);
    }

}
//move optional to controller