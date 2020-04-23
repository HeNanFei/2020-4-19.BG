package com.zjt.user_service9001.service.impl;

import com.zjt.common.entity.SysPermission2;
import com.zjt.common.entity.SysRole2;
import com.zjt.common.inter.SysRole2Mapper;
import com.zjt.user_service9001.service.ComplexSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComplexSearchServiceImpl implements ComplexSearchService {

    @Autowired
    private SysRole2Mapper sysRole2Mapper;


    @Override
    public List<SysPermission2> getUserPermissionsByName(String username) {
        return null;
    }

    @Override
    public List<SysPermission2> getUserPermissionsByUid(Integer uid) {
        List<Integer> allRoleIds = sysRole2Mapper.getUserRolesByUid(uid);


        return null;
    }
}
