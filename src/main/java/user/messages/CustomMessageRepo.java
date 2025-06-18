package user.messages;

public interface CustomMessageRepo {
    void editMessage(String messageId, String newContentString);
    void deleteMessage(String messageId);
}
