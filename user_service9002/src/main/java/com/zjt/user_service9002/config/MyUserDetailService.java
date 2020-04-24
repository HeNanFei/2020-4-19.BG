package com.zjt.user_service9002.config;

import com.zjt.common.entity.SysPermission2;
import com.zjt.common.entity.SysUser2;
import com.zjt.user_service9002.service.SysPermissionService;
import com.zjt.user_service9002.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {
    public final Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);
    @Autowired
    private UserService userService;
    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("用户名"+s);
        SysUser2 userByUsername = userService.getUserByUsername(s);
        logger.info(userByUsername.toString());
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();

        List<SysPermission2> allPermissionByUid = sysPermissionService.getAllPermissionByUid(userByUsername.getId());
        allPermissionByUid.stream().forEach(n -> list.add(new SimpleGrantedAuthority(n.getUrl())));
        User user = new User(userByUsername.getUsername(),userByUsername.getPassword(),list);
        logger.info("用户权限汇总"+user.getAuthorities().toString());
        return user;
    }
}
