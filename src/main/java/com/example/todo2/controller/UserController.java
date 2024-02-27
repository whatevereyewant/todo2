package com.example.todo2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo2.model.dto.UserDto;
import com.example.todo2.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/ver2/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserDto getDtoById(@PathVariable long id){
        log.info("[UserController][getDtoById]start");
        log.info("id: "+id);
        UserDto dto = userService.getDtoById(id);
        
        log.info("dto: "+ dto.toString());
        return dto;
    }

    @GetMapping("/username/{userId}")
    public String getUserNameById(@PathVariable Long userId){
        log.info("[UserController][getUserNameById]start");
        log.info("userId: "+userId);
        return userService.getUserNameById(userId);
    }

    @GetMapping("/find/firstname/{firstName}")
    public List<UserDto> findByUserNameStartingWith(@PathVariable String firstName){
        log.info("[UserController][findByUserNameStartingWith]start");
        log.info("firstName: "+firstName);
        return userService.findByUserNameStartingWith(firstName);
    }

    @PostMapping("/insert")
    public void insertDto(@RequestBody UserDto dto){
        log.info("[UserController][insertDto]start");
        log.info("dto: "+dto.toString());
        userService.insertDto(dto);
    }

    @PostMapping("/update")
    public void updateDto(@RequestBody UserDto dto){
        log.info("[UserController][updateDto]start");
        log.info("dto: "+dto.toString());
        userService.updateDto(dto);
    }

    @PostMapping("/delete")
    public void deleteDto(@RequestBody UserDto dto){
        log.info("[UserController][deleteDto]start");
        log.info("dto: "+dto.toString());
        userService.deleteDto(dto);
    }
}
