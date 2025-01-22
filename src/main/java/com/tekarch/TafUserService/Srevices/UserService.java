package com.tekarch.TafUserService.Srevices;


import com.tekarch.TafUserService.Models.User;

import java.util.List;

public interface UserService {

    User registerUser(User user);
    User getUserById(Long id);
    User updateUser(Long id, User user);
    List<User> getAllUsers();
}
