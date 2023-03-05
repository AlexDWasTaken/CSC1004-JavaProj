package com.alexd.messager.Controller;

import com.alexd.messager.JwtUtils;
import com.alexd.messager.Result.Result;
import com.alexd.messager.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        String token = JwtUtils.generateToken(user.getUsername());
        return Result.ok().data("token",token);
    }
}
