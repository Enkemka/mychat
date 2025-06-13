package user.messages;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface messageLogRepo extends MongoRepository <messageLog,String>  {
    //custom query to load all chats where user in chats id matches with a users id to log all thier chats

    List<messageLog> findByUsersIdInChatContaining(String userId);

    message findByMessageHistoryContaining(String messageId);

    messageLog findByChatId(String ChatId);

//make new message log object with paramter as list first item, everything else null

}
