package com.shreyas.oauth2Server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shreyas.oauth2Server.domain.User;
import com.shreyas.oauth2Server.service.UserService;

@RestController
@RequestMapping(value="/resource/user")
public class ResourceController {

  @Autowired
  private UserService userService;
  
  @RequestMapping(value = "/findAll" , method = RequestMethod.GET)
  public List<User> findAllUsers() {
    return userService.findAll();
  }
  
  @RequestMapping(value="/findOne" , method=RequestMethod.GET)
  public User findOne(@RequestParam final Long id) {
    return userService.findOne(id);
  }
}
