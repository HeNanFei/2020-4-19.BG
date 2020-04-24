package com.zjt.user_service9002.service;

import com.zjt.common.entity.SysUser2;

import java.util.List;
import java.util.Map;


public interface UserService {

    void addUser(SysUser2 sysUser);

    void deleUser(Integer uid);

    void updateUser(SysUser2 sysUser);

    List<SysUser2> findUser();

    SysUser2 getUserById(Integer id);

    SysUser2 getUserByUsername(String username);

    Map checkUser(String username, String password);

}
