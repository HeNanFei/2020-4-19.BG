package com.zjt.user_service9002.service;

import com.zjt.common.entity.SysPermission2;

import java.util.List;

public interface ComplexSearchService {

   List<SysPermission2> getUserPermissionsByName(String username);

    List<SysPermission2> getUserPermissionsByUid(Integer uid);


}
