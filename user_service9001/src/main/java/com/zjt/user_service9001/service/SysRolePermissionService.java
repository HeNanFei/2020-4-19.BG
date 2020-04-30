package com.zjt.user_service9001.service;

import com.zjt.common.entity.SysRolePermission2;

import java.util.List;

public interface SysRolePermissionService {
    int addSysRolePermission2( SysRolePermission2 sysSysRolePermission2);

    int deleSysRolePermission2(Integer uid);

    int updateSysRolePermission2( SysRolePermission2 sysSysRolePermission2);

    List< SysRolePermission2> findSysRolePermission2();

     SysRolePermission2 getSysRolePermission2ById(Integer id);

     SysRolePermission2 getSysRolePermission2BySysRolePermission2name(String username);
}
