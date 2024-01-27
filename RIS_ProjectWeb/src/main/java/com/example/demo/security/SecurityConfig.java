//package com.example.demo.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    CustomSecurityConfigurer customSecurityConfigurer() {
//        return new CustomSecurityConfigurer();
//    }
//
//    private static class CustomSecurityConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
//
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            http
//                .authorizeHttpRequests(authorize -> authorize
//                    .requestMatchers("/login/**").permitAll()
//                    .anyRequest().authenticated()
//                )
//                .formLogin(login -> login
//                    .loginPage("/login/getLoginPage")
//                    .defaultSuccessUrl("/login/success")
//                    .permitAll()
//                )
//                .logout(logout -> logout
//                    .permitAll()
//                );
//        }
//    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//			.authorizeHttpRequests((authorize) -> authorize
//				.anyRequest().authenticated()
//			)
//			.httpBasic(Customizer.withDefaults())
//			.formLogin(Customizer.withDefaults());
//
//		return http.build();
//	}
//
//    @Bean
//    UserDetailsService userDetailsService() {
//		@SuppressWarnings("deprecation")
//		UserDetails userDetails = User.withDefaultPasswordEncoder()
//			.username("user")
//			.password("password")
//			.roles("USER")
//			.build();
//
//		return new InMemoryUserDetailsManager(userDetails);
//	}
//}
