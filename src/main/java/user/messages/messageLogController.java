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

    /*@GetMapping("/{userId}")
    public List<messageLog> showHistory(@PathVariable String userId) {
        return List.of();  // empty list, to isolate if error is in DB call
    }*/


    /*@PostMapping ("/post/{userId}")
    public messageLog newMessageLog(@PathVariable String userId){
        return MessageLogService.makeUserChat(userId);
    }



    @PatchMapping("/{ChatId}")
    public messageLog addMessaage(@PathVariable String ChatId ,@RequestBody message newMsg){
        return MessageLogService.addMessage(ChatId,newMsg);
    }

    @DeleteMapping("/{ChatId}")
    public void deleteChat(String ChatId){
        MessageLogService.deleteMessageLog( ChatId);
    }*/





}
