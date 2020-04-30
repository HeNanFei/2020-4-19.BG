package com.zjt.user_service9001.service;

import com.zjt.common.entity.SysPermission2;

import java.util.List;

public interface SysPermissionService {

    SysPermission2 findSysPermissionById(Integer id);

    int deleteSysPermissionById(Integer id);

    int addSysPermission(SysPermission2 sysPermission);

    List<SysPermission2> findAllSysPermission();

    int updateSysPermission(SysPermission2 sysPermission);

    List<SysPermission2> getAllPermissionByUid(Integer uid);

}
