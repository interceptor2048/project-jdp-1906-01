package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.domain.GroupEntity;
import com.kodilla.ecommerce.repository.GroupEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupDbService {

        @Autowired
        private GroupEntityRepository groupEntityRepository;

        public List<GroupEntity> getGroupsList() {
            return groupEntityRepository.findAll();
        }

        public void createGroup(GroupEntity group) {
            groupEntityRepository.save(group);
        }

        public GroupEntity getGroup(Long groupId) {
            return groupEntityRepository.findById(groupId).orElse(null);
        }

        public GroupEntity saveGroup(final GroupEntity group) {
            return groupEntityRepository.save(group);
        }

        public void deleteById(Long groupId) {
            groupEntityRepository.deleteById(groupId);
        }

            public Optional<GroupEntity> findGroup(final String groupName) {
                return groupEntityRepository.findByName(groupName);

        }

    }

