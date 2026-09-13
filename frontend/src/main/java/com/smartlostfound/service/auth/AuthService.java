package com.smartlostfound.service.auth;

import com.smartlostfound.dto.auth.AuthResponse;
import com.smartlostfound.dto.auth.LoginRequest;
import com.smartlostfound.dto.auth.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}