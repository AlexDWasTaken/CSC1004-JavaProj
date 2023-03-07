package com.alexd.messager.Controller;

import com.alexd.messager.DAO.UserRepository;
import com.alexd.messager.DTO.User;
import com.alexd.messager.JwtUtils;
import com.alexd.messager.Result.Result;
import com.alexd.messager.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public Result login(@ModelAttribute UserLoginRequest user) {
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if (optionalUser.isEmpty()) {
            return Result.fail().setMessage("User not present");
        }
        User recordedUser = optionalUser.get();
        if(!Objects.equals(recordedUser.getPassword(), user.getPassword())) {
            return Result.fail().setMessage("Wrong password");
        }
        String token = JwtUtils.generateToken(user.getUsername());
        return Result.ok().data("token",token);
    }

    @GetMapping("/resetAdmin")
    public String resetAdmin() {
        Optional<User> optionalUser = userRepository.findByUsername("admin");
        if (optionalUser.isPresent()) {
            userRepository.deleteByUsername("admin");
        }

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        return "Successfully reset admin";
    }
}
