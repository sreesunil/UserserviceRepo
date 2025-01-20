package com.tekarch.TafUserService.Srevices;


import com.tekarch.TafUserService.DTO.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO registerUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();

}
