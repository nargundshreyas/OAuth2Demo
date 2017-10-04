package com.shreyas.oauth2Server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @RequestMapping(value = {"/" , "/home" , "/login"})
  public String home() {
    return "Home";
  }
  
}
