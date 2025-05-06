 package com.example.wheather.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.wheather.service.UserserviceImpl;

@Configuration 
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	return 	http
		  .csrf(customizer -> customizer.disable())
	      .authorizeHttpRequests(request -> request
	    		  .requestMatchers("register" , "/login")
	    		  .permitAll()
	    		  .anyRequest().authenticated())
	      .formLogin(Customizer.withDefaults())
		  .httpBasic(Customizer.withDefaults())
		  .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		  .build();
//		http.formLogin(Customizer.withDefaults());

	}
	
	@Bean 
	public AuthenticationProvider authenticationProvider(UserserviceImpl service) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(service);
		return provider;
	}
	
	@Bean 
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager(); // this will give the object just hold it 
	}
	
}
