package com.Openclassrooms.PayMyBuddy.configuration;

import com.Openclassrooms.PayMyBuddy.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public UserDetailsService userDetailsService() {
        return new UserService();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/signup", "/adduser", "/home").permitAll()
                .anyRequest().authenticated();

        // Login process
        http
                .formLogin()
                .loginPage("/home")// Specify login page
                .failureUrl("/login?error") // Transition destination when login fails
                .defaultSuccessUrl("/transfert", true);// Transition destination after success
        // Logout process
        http
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/home");
        // Disable CSRF measures (temporary)
        // http.csrf().disable() ;
    }

    @Bean
    //encodeur de mot de passe
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
