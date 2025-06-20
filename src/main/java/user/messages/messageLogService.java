package user.messages;


import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class messageLogService {


    private final messageLogRepo repo;

    @Autowired
    public messageLogService(messageLogRepo repo) {
        this.repo=repo;

    }





    // get all ,show all message logs with that users id,
public List<MessageLog> showUsersChats(String userId){
        return repo.findByUsersIdInChatContaining(userId);
        //repostory has query, if user ID is in the list of ud ids in a mesage log show it
        //it means they are a memeber of that chat
        //to load all chat history, loading all chats with user ID present
}


    //post ,make a new message log
    //add users into it
public MessageLog makeUserChat(String userId){
        MessageLog msg = new MessageLog(userId);
        msg.setUsersIdInChat(List.of(userId));
            return repo.save(msg);

//take a user id
    //make a new message log with it
    //make the user the only person in that message log list of user ids since they made it
    //save message log to database
}


public UpdateResult addMessage(String messageLogId , Message newMsg){
    return repo.addMessage(messageLogId,newMsg);

}




//edit
public UpdateResult editMessage(String messageLogId,String messageId, String newContentString){
    return repo.editMessage(messageId,messageId,newContentString);
}




public UpdateResult deleteMessage(String messageLogId,String messageId){
      return  repo.deleteMessage(messageLogId,messageId);
    }


    public void deleteMessageLog(String ChatId){
        repo.deleteById(ChatId);

    }




    //patch remove user from message log, remove thier user id

    //patch add new user to message log , add new user to userids list






}
