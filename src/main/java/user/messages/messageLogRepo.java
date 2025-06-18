package user.messages;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface messageLogRepo extends MongoRepository <MessageLog,String>,CustomMessageRepo  {
    //custom query to load all chats where user in chats id matches with a users id to log all thier chats


    List<MessageLog> findByUsersIdInChatContaining(String userId);




    Optional<MessageLog> findById(String id);

    void deleteMessageById(String id);
//make new message log object with paramter as list first item, everything else null

}
