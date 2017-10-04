package com.shreyas.oauth2Server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.shreyas.oauth2Server.config.CustomerUserDetails;
import com.shreyas.oauth2Server.repo.UserRepository;
import com.shreyas.oauth2Server.service.UserService;

@SpringBootApplication
public class OauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthApplication.class, args);
	}
	
	
	@Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService service) throws Exception {
        
        builder.userDetailsService(new UserDetailsService() {
          
          @Override
          public UserDetails loadUserByUsername(String userName)  {
            try {
              return new CustomerUserDetails(repository.findByUserName(userName));
            } catch(Exception e) {
              e.printStackTrace();
            }
            return null;
          }
        });
    }
}
