package com.yedam.quiz;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.yedam.quiz.users.service.impl.CustomLoginSuccessHandler;
import com.yedam.quiz.users.service.impl.UsersService;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity        //spring security 를 적용한다는 Annotation
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
    private final UsersService usersService;

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers( "/login", "/admin/login", "/denied", "/admin/loginError", "/resources/**").permitAll() // 모든권한
            .antMatchers("/admin/**").hasRole("ADMIN") // ADMIN 접근 허용
             //   .antMatchers("/userAccess").hasRole("USER")
            .and()
            .formLogin()
                .loginPage("/admin/login")
                .loginProcessingUrl("/admin/loginProc")
                .defaultSuccessUrl("/admin/home")
                .successHandler(new CustomLoginSuccessHandler())
                .failureUrl("/admin/loginError") // 인증에 실패했을 때 보여주는 화면 url, 로그인 form으로 파라미터값 error=true로 보낸다.
                .and()
                .csrf().disable()
            .logout()
            	.logoutUrl("/admin/logout")
            ;		//로그인 창
    }
    

    /**
     * 로그인 인증 처리 메소드
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersService).passwordEncoder(new BCryptPasswordEncoder());
    }
}


