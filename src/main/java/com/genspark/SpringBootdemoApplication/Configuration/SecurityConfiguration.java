package com.genspark.SpringBootdemoApplication.Configuration;

import com.genspark.SpringBootdemoApplication.Dao.UserDeo;
import com.genspark.SpringBootdemoApplication.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

  @Bean
  public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity h) throws Exception{
    h.cors();
    h.csrf().disable()
      .authorizeHttpRequests()
      .requestMatchers(HttpMethod.GET, "/users", "/users/{username}","/restaurants", "/{restaurantID}/items")
      .permitAll()
      .requestMatchers(HttpMethod.POST, "/users")
      .permitAll()
      .requestMatchers("/auth")
      .authenticated()
      .requestMatchers("/login")
      .authenticated()
      .requestMatchers(HttpMethod.POST, "/restaurants", "/items")
      .hasRole("OWNER")
      .anyRequest()// Unless specified, all url pages will fall under anyRequests(). You would need to specify the type of security such as permit all or authentication for it to work. Think firewalls where the last rules deny all packets
      .authenticated()
      .and()
      .formLogin()
      .and()
      .httpBasic();

    return h.build();


  }


}
