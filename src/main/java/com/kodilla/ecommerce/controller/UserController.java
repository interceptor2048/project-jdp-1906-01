package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.domain.dto.UserDto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("v1/user")
public class UserController {


    @GetMapping(value = "getUsers")
    public List<UserDto> getUsers() {
        return new ArrayList<>();
    }

    @GetMapping (value = "getUser")
    public UserDto getUser( @RequestParam("userId") Long userId ) {
        return new UserDto(1L, "user1", false, 13L);
    }
    @PostMapping(value = "createUser")
    public void createUser(@RequestBody UserDto user){
    }
    @PutMapping( value = "blockUser")
    public UserDto blockUser( @RequestParam Long userId, @RequestBody UserDto userDto) {
        return new UserDto(1L, "user2", true, 12L);
    }
    @GetMapping (value = "generateUserIdKey")
    public Long generateUserIdKey(@RequestParam Long userId) {
        Long randomKey = new Random().nextLong();
        return userId + randomKey;
    }
}
