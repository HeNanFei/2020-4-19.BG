package com.zjt.user_service9001.service;

import com.zjt.common.entity.SysUser2;

import java.util.List;
import java.util.Map;


public interface UserService {

    int addUser(SysUser2 sysUser);

    int deleUser(Integer uid);

    int updateUser(SysUser2 sysUser);

    List<SysUser2> findUser(Integer pageIndex,Integer PageSize);

    SysUser2 getUserById(Integer id);

    SysUser2 getUserByUsername(String username);

    Map checkUser(String username,String password);

    List<SysUser2> findUser();


}
