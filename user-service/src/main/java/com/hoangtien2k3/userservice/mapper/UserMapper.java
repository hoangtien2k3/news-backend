package com.hoangtien2k3.userservice.mapper;

import com.hoangtien2k3.userservice.dto.request.UserCreationRequest;
import com.hoangtien2k3.userservice.dto.request.UserUpdateRequest;
import com.hoangtien2k3.userservice.dto.response.UserResponse;
import com.hoangtien2k3.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreationRequest userCreationRequest);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);

}
