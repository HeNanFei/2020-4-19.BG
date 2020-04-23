package com.zjt.user_service9001.service;

import com.zjt.common.entity.SysPermission2;
import com.zjt.common.entity.SysRole2;

import java.util.List;

public interface ComplexSearchService {

   List<SysPermission2> getUserPermissionsByName(String username);

    List<SysPermission2> getUserPermissionsByUid(Integer uid);


}
