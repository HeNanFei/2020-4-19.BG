package com.zjt.user_service9001.service;

import com.zjt.common.entity.SysPermission2;

import java.util.List;

public interface SysPermissionService {

    SysPermission2 findSysPermissionById(Integer id);

    void deleteSysPermissionById(Integer id);

    void addSysPermission(SysPermission2 sysPermission);

    List<SysPermission2> findAllSysPermission();

    void updateSysPermission(SysPermission2 sysPermission);

}
