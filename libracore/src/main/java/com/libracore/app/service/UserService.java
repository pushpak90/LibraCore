package com.libracore.app.service;

import com.libracore.app.dto.auth.RegisterRequest;

public interface UserService {
    void register(RegisterRequest request);
}
