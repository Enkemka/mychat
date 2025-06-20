package user.messages;

import com.mongodb.client.result.UpdateResult;

public interface CustomMessageRepo {
    UpdateResult editMessage(String messageLogId,String messageId, String newContentString);
    UpdateResult deleteMessage(String messageLogId,String messageId);
    UpdateResult addMessage(String messageLogId , Message newContentString);
}
