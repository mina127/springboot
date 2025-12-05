package com.korit.springboot.controller;

import com.korit.springboot.config.BeanConfig;
import com.korit.springboot.dto.CreateUserReqDto;
import com.korit.springboot.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    //@Autowired
    private final UserService userService;
    //private final BeanConfig.A a; // A도 의존성 주입해라
    @PostMapping("/api/users")
    public ResponseEntity<Map<String,Integer>> create(@Valid @RequestBody CreateUserReqDto dto)
    {
        userService.duplicatedUsername(dto.getUsername());
        int createdUserId = userService.createUser(dto);
        //a.print();
        return ResponseEntity.ok(Map.of("createdUserId",createdUserId));
    }

}
