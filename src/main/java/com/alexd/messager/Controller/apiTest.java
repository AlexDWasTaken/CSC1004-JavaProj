package com.alexd.messager.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class apiTest {

    //Test whether the backend application is running successfully.
    @GetMapping("/Test")
    public String Status() {
        return "Success!";
    }
}
