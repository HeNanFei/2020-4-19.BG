package com.zjt.user_service9001.config;

import com.zjt.common.entity.SysPermission2;
import com.zjt.common.inter.SysPermission2Mapper;
import com.zjt.security.components.DynamicSecurityService;
import com.zjt.security.config.SecuModuleConfig;
import com.zjt.user_service9001.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Config extends SecuModuleConfig {
    @Autowired
    private MyUserDetailService myUserDetailService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息


        return username -> myUserDetailService.loadUserByUsername(username);
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {



        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {


                logger.info("Config 动态添加权限");

                Map<String,ConfigAttribute> map = new HashMap<>();
                List<SysPermission2> allSysPermission = sysPermissionService.findAllSysPermission();
                allSysPermission.stream().forEach(n -> map.put(n.getUrl(),new SecurityConfig(n.getUrl())));
                logger.info(map.toString());

                return map;
            }
        };
    }
    @Bean
    public  PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
