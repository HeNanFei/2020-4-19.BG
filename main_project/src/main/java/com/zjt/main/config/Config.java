package com.zjt.main.config;

import cn.hutool.core.io.LineHandler;
import com.zjt.security.components.DynamicSecurityService;
import com.zjt.security.config.SecuModuleConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Config extends SecuModuleConfig {
    @Autowired
    private MyUserDetailService myUserDetailService;

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
       /* return username -> (((UserDetailsService) s -> {
            ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();
            list.add(new SimpleGrantedAuthority("/jpa"));
            list.add(new SimpleGrantedAuthority("/jpa2"));
            return new User("username", passwordEncoder().encode("password"), list);
        }).loadUserByUsername(username));*/

        return username -> myUserDetailService.loadUserByUsername(username);
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {



        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {


                logger.info("Config 动态添加权限");

                Map<String,ConfigAttribute> map = new HashMap<>();
                SecurityConfig securityConfig = new SecurityConfig("/jpa");
                SecurityConfig securityConfig2 = new SecurityConfig("/jpa2");
                SecurityConfig securityConfig3 = new SecurityConfig("/jpa3");

                map.put("/jpa",securityConfig);
                map.put("/jpa2",securityConfig2);
                map.put("/jpa3",securityConfig3);

                return map;
            }
        };
    }
    @Bean
    public  PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
