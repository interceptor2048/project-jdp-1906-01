//package com.kodilla.ecommerce.maper;
//
//package com.kodilla.ecommerce.maper;
//
//import com.kodilla.ecommerce.domain.GroupEntity;
//import com.kodilla.ecommerce.domain.dto.GroupDto;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class GroupMapper {
//
//
//    public GroupEntity mapToGroup( final GroupDto groupDto) {
//        GroupEntity group = new GroupEntity();
//        group.getOrders().add(order);
//        group.getProducts().addAll(mapToProductList(orderDto.getProducts(), order));
//        return new GroupEntity(groupDto.getId(),
//                groupDto.getGroup_name(),
//                mapToProductDtoList(groupDto.getProductsList()));
//    }
//
//    public GroupDto mapToGroupDto(final GroupEntity group) {        return new GroupDto(
//            group.getId(),
//            group.getName(),
//            productMapper.mapToProductDtoList(group.getProductsList()));
//    }
//
//    public List<GroupDto> mapToGroupDtoList( final List<GroupEntity> groupList) {
//        return groupList.stream()
//                .map(g -> new GroupDto(g.getId(), g.getName(), mapToProductDtoList(g.getProductsList())))
//                .collect(Collectors.toList());
//    }
