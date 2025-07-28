package com.foliaco.user_service.user.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.foliaco.user_service.user.dto.request.UserRequest;
import com.foliaco.user_service.user.dto.response.UserResponse;
import com.foliaco.user_service.user.model.User;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserMapper {

    private ModelMapper modelMapper;

    private AddressMapper addressMapper;

    public User toUser(UserRequest request){

        return User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .password(request.password())
                .phoneNumber(request.phoneNumber())
                .address( addressMapper.toAddress(request.address()) )
                .build();

    }

    public UserResponse toUserResponse(User user){
        return modelMapper.map(user, UserResponse.class);
    }

}
