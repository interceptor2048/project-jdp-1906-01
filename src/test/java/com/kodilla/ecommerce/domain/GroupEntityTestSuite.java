package com.kodilla.ecommerce.domain;


import com.kodilla.ecommerce.service.GroupDbService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupEntityTestSuite {


    @Autowired
    GroupDbService groupDbService;

    @Test
    public void testGetGroups() {
        //Given
        GroupEntity group1 = new GroupEntity("Group1");
        // groupDbService.saveGroup(group1);
        GroupEntity group2 = new GroupEntity("Group2");
        // groupDbService.saveGroup(group2);
        GroupEntity group3 = new GroupEntity("Group3");
        groupDbService.saveGroup(group3);
        //When
        List<GroupEntity> listGroups = groupDbService.getGroupsList();
        //Then
        Assert.assertEquals(3, listGroups.size());
        System.out.println(listGroups.get(0).getName());
        System.out.println(listGroups.get(1).getName());
        System.out.println(listGroups.get(2).getName());

    }

    @Test
    public void testGetGroup() {
        //Given
        GroupEntity group1 = new GroupEntity("Group1");
        groupDbService.saveGroup(group1);
        //When
        Long idGroup = groupDbService.findGroup("Group1").get().getId();
        GroupEntity receivedGroup = groupDbService.getGroup(idGroup);
        String testGroupName = receivedGroup.getName();
        //Then
        Assert.assertEquals("Group1", testGroupName);
    }

    @Test
    public void testCreateGroup() {
        //Given
        List<GroupEntity> emptyGroupList = groupDbService.getGroupsList();
        GroupEntity group2 = new GroupEntity("Group2");
        groupDbService.saveGroup(group2);
        //When
        List<GroupEntity> groupListWithCreatedGroup = groupDbService.getGroupsList();
        //Then
        Assert.assertEquals(emptyGroupList.size() + 1, groupListWithCreatedGroup.size());
    }


    @Test
    public void testUpdateGroup() {
        //Given
        GroupEntity group3 = new GroupEntity("Group3");
        groupDbService.saveGroup(group3);
        Long idTestedGroup = groupDbService.findGroup("Group3").get().getId();
        //When
        GroupEntity group3Updated = groupDbService.findGroup("Group3").get();
        group3Updated.setName("Group3Updated");
        groupDbService.saveGroup(group3Updated);
        String groupNameAfterUpdate = groupDbService.getGroup(idTestedGroup).getName();
        //Then
        Assert.assertEquals("Group3Updated", groupNameAfterUpdate);
        groupDbService.deleteById(idTestedGroup);
    }

}

