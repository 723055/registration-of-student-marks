package org.pflb.vault.config;

import org.pflb.vault.security.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    StudentDetailsService studentDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/swagger-ui.html").permitAll()
                .anyRequest().permitAll();

        http.formLogin().permitAll();

        http.logout()
                .permitAll()
                .invalidateHttpSession(true);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(studentDetailsService);

    }

    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/h2console/**");

    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder(){
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return String.valueOf(rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.equals(encodedPassword);
            }
        };
    }


}
