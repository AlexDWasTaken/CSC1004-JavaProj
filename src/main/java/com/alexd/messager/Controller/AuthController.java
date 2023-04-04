package com.alexd.messager.Controller;

import com.alexd.messager.DAO.UserRepository;
import com.alexd.messager.DTO.User;
import com.alexd.messager.JwtUtils;
import com.alexd.messager.Result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @GetMapping("/check-auth")
    public ResponseEntity<?> checkAuth(@RequestHeader(name = "Authorization") String token) {
        // 验证令牌(token)是否有效，可以使用Spring Security或其他身份验证机制。
        if (isValidToken(token)) {
            return ResponseEntity.ok("{\"authenticated\": true}");
        } else {
            return ResponseEntity.ok("{\"authenticated\": false}");
        }
    }

    private boolean isValidToken(String token) {
        // 实现令牌(token)验证逻辑，比如使用JWT或者其他验证机制。
        // 如果验证通过，则返回true，否则返回false。
        String username = JwtUtils.getClaimsByToken(token).getSubject();

        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            return true;
        }
        return false;
    }
}

