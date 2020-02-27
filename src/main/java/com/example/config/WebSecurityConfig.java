package com.example.config;

import com.example.service.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthenticationSuccessHandler authSuccessHandler;

    private final CustomerUserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(AuthenticationSuccessHandler authSuccessHandler,
                             CustomerUserDetailsService userDetailsService) {
        this.authSuccessHandler = authSuccessHandler;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
                .disable();
        http.authorizeRequests()
                .antMatchers("/register", "/home", "/login").permitAll()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN");
        http.formLogin()
                .loginPage("/login")
                // Перенапровление пользователя
                .successHandler(authSuccessHandler)
                .and()
                // Прова доступа
                .exceptionHandling().accessDeniedPage("/access_denied");
        http.logout()
                .logoutUrl("/logout")
                // указываем URL при удачном логауте
                .logoutSuccessUrl("/")
                // делаем не валидной текущую сессию
                .invalidateHttpSession(true)
                .deleteCookies ("JSESSIONID");
    }
}
