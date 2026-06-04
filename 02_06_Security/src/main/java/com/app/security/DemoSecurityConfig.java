package com.app.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	@Bean
	UserDetailsManager userDetailManager(DataSource datasource) {
//		JdbcUserDetailsManager jdbc = new JdbcUserDetailsManager(datasource);
//
//		jdbc.setUsersByUsernameQuery("");
//		jdbc.setAuthoritiesByUsernameQuery("");
//
//		return jdbc;
		 return new JdbcUserDetailsManager(datasource);

	}

//	@Bean
//	InMemoryUserDetailsManager userDetailManager() {
//
//		UserDetails user1 = User.builder().username("ishwar").password("{noop}ISHWAR").roles("Employee", "Developer","Manager")
//				.build();
//		UserDetails user2 = User.builder().username("ashish").password("{noop}ASHISH").roles("Employee").build();
//		UserDetails user3 = User.builder().username("sidd").password("{noop}SIDD").roles("Employee","Manager").build();
//
//		return new InMemoryUserDetailsManager(user1, user2, user3);
//	}

	@Bean
	SecurityFilterChain filterchain(HttpSecurity http) {
		http.authorizeHttpRequests(configurer -> configurer.requestMatchers("/").hasRole("EMPLOYEE")
				.requestMatchers("/leader").hasRole("DEVELOPER").requestMatchers("/system").hasRole("MANAGER")
				.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser")
						.permitAll())
				.logout(logout -> logout.permitAll())
				.exceptionHandling(configurer -> configurer.accessDeniedPage("/acess-denied"));
		return http.build();
	}

}
