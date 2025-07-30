package com.foliaco.user_service.user.service.impl;

import java.time.Instant;
import java.util.List;

import com.foliaco.user_service.exception.NotFoundException;
import com.foliaco.user_service.user.dto.request.UserRequest;
import com.foliaco.user_service.user.dto.response.DataPaginator;
import com.foliaco.user_service.user.dto.response.UserResponse;
import com.foliaco.user_service.user.mapper.UserMapper;
import com.foliaco.user_service.user.model.Address;
import com.foliaco.user_service.user.model.User;
import com.foliaco.user_service.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.foliaco.user_service.user.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    private UserRepository userRepository;

    @Override
    public String createUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        user.setCreateAt(Instant.now());
        user = userRepository.save(user);
        return user.getId();
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest) {

        User user = userRepository.findById(userRequest.id()).orElseThrow(() -> new NotFoundException("User not found"));
        user.setFirstname(userRequest.firstname());
        user.setLastname(userRequest.lastname());
        user.setEmail(userRequest.email());
        user.setPhoneNumber(userRequest.phoneNumber());
        user.setUpdateAt(Instant.now());

        Address address = user.getAddress() != null ? user.getAddress() : new Address();
        address.setCity(userRequest.address().city());
        address.setCountry(userRequest.address().country());
        address.setState(userRequest.address().state());
        address.setStreet(userRequest.address().street());

        user.setAddress(address);
        userRepository.save(user);

        return userMapper.toUserResponse(user);

    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        userRepository.delete(user);
    }

    @Override
    public UserResponse getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        return userMapper.toUserResponse(user);
    }

    @Override
    public DataPaginator<List<UserResponse>> getAllUsers(Pageable pageable) {

        Page<User> userPage = userRepository.findAll(pageable);
        DataPaginator<List<UserResponse>> dataPaginator = new DataPaginator<>();
        
        if (userPage.isEmpty()) {
            return dataPaginator;
        }

        List<UserResponse> userResponses = userPage.getContent().stream()
                .map(userMapper::toUserResponse)
                .toList();

        dataPaginator.setData(userResponses);
        dataPaginator.setCurrentPage(userPage.getNumber());
        dataPaginator.setTotalPages(userPage.getTotalPages());
        return dataPaginator;

    }

}
