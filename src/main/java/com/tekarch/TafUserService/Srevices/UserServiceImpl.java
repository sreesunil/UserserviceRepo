package com.tekarch.TafUserService.Srevices;

import com.tekarch.TafUserService.Models.User;

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
    public User registerUser(User user) {

        return restTemplate.postForObject(datastoreServiceUrl , user , User.class);
    }

    @Override
    public User getUserById(Long id) {
        return restTemplate.getForObject(datastoreServiceUrl + "/" + id, User.class);
    }


    @Override
    public User updateUser(Long id, User user) {
        restTemplate.put(datastoreServiceUrl + "/" + id, user);
        return user;
    }


    @Override
    public List<User> getAllUsers() {
        return Arrays.asList(restTemplate.getForObject(datastoreServiceUrl, User[].class));
    }


}
