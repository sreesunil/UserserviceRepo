package com.tekarch.TafUserService.Srevices;

import com.tekarch.TafUserService.DTO.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${datastore.service.url}")
     String datastoreServiceUrl;



    @Override
    public UserDTO registerUser(UserDTO userDTO) {

        return restTemplate.postForObject(datastoreServiceUrl , userDTO , UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long id) {

        return restTemplate.getForObject(datastoreServiceUrl , UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        UserDTO[] userArray=  restTemplate.getForObject(datastoreServiceUrl+ "/users" , UserDTO[].class);
        return Arrays.asList(userArray);
    }


}
