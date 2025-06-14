package user.messages;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "MessageLog")
public class MessageLog {

    @Id
    private String id;


    private List<String> usersIdInChat;
    private List<Message> messageHistory;

    public MessageLog(String ChatId, List<String> UsersIdInChat, List<Message> MessageHistory) {
        this.id = ChatId;
        this.usersIdInChat = UsersIdInChat;
        this.messageHistory = MessageHistory;
    }
    public MessageLog() {}

    public MessageLog addNewMessage(Message New){

         this.messageHistory.add(New);
         return this;
    }




    public MessageLog(String userId) {

        this.usersIdInChat =List.of(userId);
    }

    public String getChatId() {

        return id;
    }

    public void setChatId(String chatId) {

        chatId = chatId;
    }

    public List<String> getUsersIdInChat() {

        return usersIdInChat;
    }

    public void setUsersIdInChat(List<String> usersIdInChat) {

        usersIdInChat = usersIdInChat;
    }

    public List<Message> getMessageHistory() {

        return messageHistory;
    }

    public void setMessageHistory(List<Message> messageHistory) {

        messageHistory = messageHistory;
    }





}
