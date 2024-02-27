package com.example.todo2.service;

import org.springframework.stereotype.Service;

import com.example.todo2.model.dto.UserDto;
import com.example.todo2.model.repo.UserRepo;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    
    private UserRepo userRepo;

    public UserDto getDtoById(long id){
        log.info("[UserService][getDtoById]Start");
        if(id==0){
            log.error("[UserService][getDtoById]error");
            return new UserDto();
        }
        return userRepo.getReferenceById(id);
    }

    public void insertDto(UserDto dto){
        log.info("[UserService][insertDto]Start");
        userRepo.save(dto);
    }

    public String getUserNameById(Long userId){
        log.info("[UserService][getUserNameById]Start");
        return userRepo.getUserNameById(userId);
    }

    public List<UserDto> findByUserNameStartingWith(String firstName){
        log.info("[UserService][findByUserNameStartingWith]Start");
        return userRepo.findByUserNameStartingWith(firstName);
    }

    public void updateDto(UserDto dto){
        UserDto user = userRepo.findByUserName(dto.getUserName());
        if(dto.getUserAge()>0){
            user.setUserAge(dto.getUserAge());
        }
        userRepo.save(user);
    }

    public void deleteDto(UserDto dto){
        UserDto user = userRepo.findByUserName(dto.getUserName());
    userRepo.delete(user);
    }
}
