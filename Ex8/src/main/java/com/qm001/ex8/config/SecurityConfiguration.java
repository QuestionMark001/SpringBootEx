package com.qm001.ex8.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userdataService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login") // 登录页面设置
                .loginProcessingUrl("/user-login") // 登录访问路径
                .defaultSuccessUrl("/admin") .permitAll() // 登录成功之后，跳转路径
                .and()
                .logout()
                .logoutUrl("/logout") // 登出访问路径
                .logoutSuccessUrl("/login") // 登出成功之后，跳转路径
                .deleteCookies("JSESSIONID") // 清除 Cookies
                .and()
                .authorizeRequests()
                .antMatchers("/favicon", "/loginAssets/**").permitAll() // 配置需要放行的静态资源
                .anyRequest().authenticated()
                .and()
                .csrf().disable(); // 关闭 CSRF 安全防护
    }
}
