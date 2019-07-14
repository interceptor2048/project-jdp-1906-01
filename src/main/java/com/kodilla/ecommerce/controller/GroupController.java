package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.domain.dto.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommerce/group")
public class GroupController {

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        return new ArrayList<>();
    }

    @PostMapping(value = "createGroup")
    public void createGroup(@RequestBody GroupDto group) {
    }

    @GetMapping(value = "getGroup")
    public GroupDto getGroup(@RequestParam("groupId") Long groupId, String group_name) {
        return new GroupDto(1L,"Group1");
    }

    @PutMapping(value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto group) {
        return group;
    }
}

