package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("v1/user")
public class UserController {


    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser( @RequestParam("userId") Long userId ) {
        return new UserDto(1L, "user1", false, 13L);
    }
    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createUser(@RequestBody UserDto user){
    }
    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public UserDto blockUser(@RequestParam Long userId, @RequestBody UserDto userDto) {
        return new UserDto(1L, "user2", true, 12L);
    }
    @RequestMapping(method = RequestMethod.GET, value = "generateUserIdKey")
    public Long generateUserIdKey(@RequestParam Long userId) {
        Long randomKey = new Random().nextLong();
        return userId + randomKey;
    }
}

