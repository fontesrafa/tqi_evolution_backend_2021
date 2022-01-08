package br.com.tqi.creditanalysis.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.tqi.creditanalysis.security.AuthUserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthUserDetailsService authUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEnconder;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
       auth.userDetailsService(authUserDetailsService).passwordEncoder((PasswordEncoder) passwordEnconder);      
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/h2-console/**").permitAll();
        http.authorizeRequests()
                    .antMatchers(HttpMethod.GET,"/api/v1/clients/**").authenticated()
                    .antMatchers(HttpMethod.POST,"/api/v1/clients").permitAll()
                    .antMatchers("/h2-console/**").permitAll()
                    .antMatchers("/api/v1/loans").authenticated()                                                          
                    .and()
                    .formLogin()
                    .and()
                    .httpBasic()
                    .and()
                    .logout();                    
        http.headers().frameOptions().sameOrigin();   
    }
    
}
