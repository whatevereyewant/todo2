package com.example.todo2.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.todo2.model.dto.UserDto;

public interface UserRepo extends JpaRepository<UserDto, Long>{
    
    @Query(value = "select user_name from customer where id= :userId", nativeQuery = true)
    public String getUserNameById(@Param("userId") Long userId);

    public List<UserDto> findByUserNameStartingWith(String firstName);

    public UserDto findByUserName(String userName);
}
