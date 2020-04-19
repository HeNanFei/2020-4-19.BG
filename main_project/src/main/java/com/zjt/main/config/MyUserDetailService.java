package com.zjt.main.config;

import com.zjt.main.Repository.UauthorityRepository2;
import com.zjt.main.entity.Uauthority2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
@Service
public class MyUserDetailService implements UserDetailsService {
    public final Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);
    @Autowired
    private UauthorityRepository2 uauthorityRepository2;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("用户名"+s);
        Uauthority2 byUsername = uauthorityRepository2.findByUsername(s);
        logger.info(byUsername.toString());
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();
        String[] split = byUsername.getAuthorities().split(",");
        Arrays.asList(split).stream().forEach(n ->{list.add(new SimpleGrantedAuthority(n));});
        User user = new User(byUsername.getUsername(),byUsername.getPassword(),list);
        return user;
    }
}
