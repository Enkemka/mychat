package user.messages;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface messageLogRepo extends MongoRepository<messageLog,String>  {
    //custom query to load all chats where user in chats id matches with a users id to log all thier chats
    @Query("{'UsersIdInChat':?0}")
    List<messageLog> findAllWithUserId(String userId);
}
