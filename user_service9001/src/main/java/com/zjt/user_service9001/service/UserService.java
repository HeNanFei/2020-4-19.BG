package com.zjt.user_service9001.service;

import com.zjt.common.entity.SysUser2;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    void addUser(SysUser2 sysUser);

    void deleUser(Integer uid);

    void updateUser(SysUser2 sysUser);

    List<SysUser2> findUser();

    SysUser2 getUserById(Integer id);

    SysUser2 getUserByUsername(String username);

}
