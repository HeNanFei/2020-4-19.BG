package com.zjt.user_service9002.service;

import com.zjt.common.entity.SysUserRole2;

import java.util.List;

public interface SysUserRoleService {

    void addSysUserRole2(SysUserRole2 sysSysUserRole2);

    void deleSysUserRole2(Integer uid);

    void updateSysUserRole2(SysUserRole2 sysSysUserRole2);

    List< SysUserRole2> findSysUserRole2();

    SysUserRole2 getSysUserRole2ById(Integer id);

    SysUserRole2 getSysUserRole2BySysUserRole2name(String username);

}
