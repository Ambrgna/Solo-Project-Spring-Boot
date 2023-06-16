package com.genspark.SpringBootdemoApplication.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

  @Autowired
  private DataSource dataSource;

  @Autowired
  public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, enabled from tbl_users where username=?")
            .authoritiesByUsernameQuery("select username, role from tbl_users where username=?");
  }

  @Bean
  public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity h) throws Exception{
    h.cors();
    h.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers(HttpMethod.GET, "/**")
            .permitAll()
            .requestMatchers(HttpMethod.POST, "/users")
            .permitAll()
            .requestMatchers("/authenticated")
            .authenticated()
            .requestMatchers("/login")
            .authenticated()
            .requestMatchers(HttpMethod.POST, "/restaurants", "/items")
            .hasRole("OWNER")
//            .authenticated()
            .anyRequest()// Unless specified, all url pages will fall under anyRequests(). You would need to specify the type of security such as permit all or authentication for it to work. Think firewalls where the last rules deny all packets
            .authenticated()
            .and()
            .formLogin()
            .and()
            .logout()
            .logoutUrl("/logout")
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .and()
            .httpBasic();

    return h.build();


  }


}
