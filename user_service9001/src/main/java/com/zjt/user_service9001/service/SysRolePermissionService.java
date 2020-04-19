package com.zjt.user_service9001.service;

import com.zjt.common.entity.SysRolePermission2;

import java.util.List;

public interface SysRolePermissionService {
    void addSysRolePermission2( SysRolePermission2 sysSysRolePermission2);

    void deleSysRolePermission2(Integer uid);

    void updateSysRolePermission2( SysRolePermission2 sysSysRolePermission2);

    List< SysRolePermission2> findSysRolePermission2();

     SysRolePermission2 getSysRolePermission2ById(Integer id);

     SysRolePermission2 getSysRolePermission2BySysRolePermission2name(String username);
}
