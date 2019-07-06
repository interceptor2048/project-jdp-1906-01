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
        Assert.assertEquals(4, listGroups.size());
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
        GroupEntity group3Updated = new GroupEntity();
        groupDbService.saveGroup(group3Updated);
        String groupNameAfterUpdate = groupDbService.getGroup(idTestedGroup).getName();
        //Then
        Assert.assertEquals("Group3", groupNameAfterUpdate);
        groupDbService.deleteById(idTestedGroup);
    }
}

