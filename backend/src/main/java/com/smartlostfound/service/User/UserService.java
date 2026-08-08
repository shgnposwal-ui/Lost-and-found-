package com.smartlostfound.service.user;

import com.smartlostfound.dto.auth.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    void deleteUser(Long id);
}