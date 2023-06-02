package com.qm001.ex8.config;

import com.qm001.ex8.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class Security implements UserDetailsService {
    @Autowired
    private UserDao ass;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询账户信息
        com.qm001.ex8.domain.LoginUser account1 = ass.Users(username);
        System.out.println(account1);
        // 账户不存在时，逻辑
        if (account1 == null) {
            throw new UsernameNotFoundException("没有该账户");
        }
        // 这是一个关于 Spring Security 的方法，用于将逗号分隔的角色字符串转换为权限列表。
        List<GrantedAuthority> authorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new User(account1.getName(), "{bcrypt}" +
                new BCryptPasswordEncoder().encode(account1.getPassword()), authorities);
    }
}

