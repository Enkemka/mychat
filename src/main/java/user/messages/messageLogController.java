package user.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/home")
public class messageLogController {

    private final messageLogService MessageLogService;

    @Autowired
    public messageLogController(messageLogService MessageLogService){
        this.MessageLogService = MessageLogService;
    }

    @GetMapping("/{userId}")
    public List<messageLog> showHistory(@PathVariable String userId){

return MessageLogService.showUsersChats(userId);
    }



    @PostMapping ("/{newChat}")
    public messageLog newMessageLog(@RequestBody String userId){
        return MessageLogService.makeUserChat(userId);
    }

    @PutMapping

}
