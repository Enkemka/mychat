package user.messages;

import com.mongodb.client.result.UpdateResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/home")
public class messageLogController {

    private final messageLogService MessageLogService;


    @GetMapping("/test")
    public String test() {
        return "Controller is reachable!";
    }



    @Autowired
    public messageLogController(messageLogService MessageLogService){
        this.MessageLogService = MessageLogService;
    }

    @GetMapping("/{userId}")
    public List<MessageLog> showHistory(@PathVariable String userId){

return MessageLogService.showUsersChats(userId);
    }
    //showing list of chats with user in it



    @PostMapping ("/post/{userId}")
    public MessageLog newMessageLog(@PathVariable String userId){
        return MessageLogService.makeUserChat(userId);
    }




    //front end will genrate message
    //front end will get message values from token
    @PatchMapping("/chats/{ChatId}/messages")
    public ResponseEntity<?> addMessaage(@PathVariable String ChatId , @RequestBody Message newMsg){

UpdateResult result = MessageLogService.addMessage(ChatId, newMsg);
 if(result.getModifiedCount()>0){
     System.out.println("sucess");
     return ResponseEntity.ok(result);
 }
        System.out.println("fail");
 return ResponseEntity.notFound().build();

    }


    @PatchMapping("/chats/{ChatId}/message{messageId}")
    public ResponseEntity<?> editMessaage(@PathVariable String ChatId ,@PathVariable String messageId, @RequestBody String newContentString){

        UpdateResult result = MessageLogService.editMessage(ChatId,messageId, newContentString);
        if(result.getModifiedCount()>0){
            System.out.println("sucess");
            return ResponseEntity.ok(result);
        }
        System.out.println("fail");
        return ResponseEntity.notFound().build();

    }
















    //



    @DeleteMapping("/{ChatId}")
    public void deleteChat(String ChatId){
        MessageLogService.deleteMessageLog( ChatId);
    }





}
