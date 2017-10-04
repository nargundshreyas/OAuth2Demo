package com.shreyas.oauth2Server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreyas.oauth2Server.domain.User;
import com.shreyas.oauth2Server.repo.UserRepository;
import com.shreyas.oauth2Server.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
  
  /* (non-Javadoc)
   * @see com.shreyas.oauth2Server.service.impl.UserService#save(com.shreyas.oauth2Server.domain.User)
   */
  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User findOne(Long id) {
    return userRepository.findOne(id);
  }
  
  
}
