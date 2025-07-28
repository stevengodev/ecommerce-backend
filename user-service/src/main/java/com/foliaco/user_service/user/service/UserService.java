package com.foliaco.user_service.user.service;

import java.util.List;

import com.foliaco.user_service.user.dto.request.UserRequest;
import org.springframework.data.domain.Pageable;

import com.foliaco.user_service.user.dto.response.DataPaginator;
import com.foliaco.user_service.user.dto.response.UserResponse;

public interface UserService {

    String createUser(UserRequest userRequest);
    UserResponse updateUser(UserRequest userRequest);
    void deleteUser(String userId);
    UserResponse getUserById(String userId);
    DataPaginator<List<UserResponse>> getAllUsers(Pageable pageable);
    
}
