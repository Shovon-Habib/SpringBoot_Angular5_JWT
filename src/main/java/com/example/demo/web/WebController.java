package com.example.demo.web;

import com.example.demo.dto.Message;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class WebController {

    private final UserService userService;

    @Autowired
    public WebController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = userService.getAllUsers();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUser(Long.valueOf(id)));
    }

    @DeleteMapping("/")
    public ResponseEntity<Message> deleteUser(HttpServletRequest request) {
        Long id = Long.valueOf(request.getHeader("id"));
        System.out.println(request.getHeader("id"));
        return ResponseEntity.ok(new Message().attach(userService.delete(id)));
    }

    @PostMapping
    public ResponseEntity<Message> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok(new Message().attach("User added successfully"));
    }

    @PutMapping
    ResponseEntity<Message> updateUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(new Message().attach(userService.updateUser(userDto)));
    }
}
