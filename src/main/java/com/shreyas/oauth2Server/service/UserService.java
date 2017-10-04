package com.shreyas.oauth2Server.service;

import java.util.List;

import com.shreyas.oauth2Server.domain.User;


public interface UserService {

  User save(User user);
  
  List<User> findAll();
  
  User findOne(Long id);

}
