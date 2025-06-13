package com.example.mychat.admin;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/userSettings")
public class settingsController {

    @GetMapping("/test")
    public String test() {
        return "Test endpoint is working!";
    }

}
