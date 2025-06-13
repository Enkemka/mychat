package user.messages;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "messageLog")
public class messageLog {

    @Id
    private String ChatId;
    private List<String> UsersIdInChat;
    private List<message> MessageHistory;

    public messageLog(String ChatId, List<String> UsersIdInChat, List<message> MessageHistory) {
        this.ChatId = ChatId;
        this.UsersIdInChat = UsersIdInChat;
        this.MessageHistory = MessageHistory;
    }

    public messageLog addNewMessage(message New){

         this.MessageHistory.add(New);
         return this;
    }




    public messageLog(String userId) {

        this.UsersIdInChat =List.of(userId);
    }

    public String getChatId() {

        return ChatId;
    }

    public void setChatId(String chatId) {

        ChatId = chatId;
    }

    public List<String> getUsersIdInChat() {

        return UsersIdInChat;
    }

    public void setUsersIdInChat(List<String> usersIdInChat) {

        UsersIdInChat = usersIdInChat;
    }

    public List<message> getMessageHistory() {

        return MessageHistory;
    }

    public void setMessageHistory(List<message> messageHistory) {

        MessageHistory = messageHistory;
    }





}
