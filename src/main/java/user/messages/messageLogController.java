package user.messages;

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



    @PatchMapping("/{ChatId}")
    public MessageLog addMessaage(@PathVariable String ChatId ,@RequestBody Message newMsg){
        return MessageLogService.addMessage(ChatId,newMsg);
    }

    //delete message (patch)

    //edut message



    //



    @DeleteMapping("/{ChatId}")
    public void deleteChat(String ChatId){
        MessageLogService.deleteMessageLog( ChatId);
    }





}
