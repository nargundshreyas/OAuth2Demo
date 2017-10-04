package com.shreyas.oauth2Server.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreyas.oauth2Server.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

  public User findByUserName(String userName);
}
