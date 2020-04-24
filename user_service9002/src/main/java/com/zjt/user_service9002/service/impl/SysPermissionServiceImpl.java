package com.zjt.user_service9002.service.impl;


import com.zjt.common.entity.SysPermission2;
import com.zjt.common.entity.SysPermission2Example;
import com.zjt.common.inter.SysPermission2Mapper;
import com.zjt.user_service9002.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermission2Mapper sysPermissionMapper;



    @Override
    public SysPermission2 findSysPermissionById(Integer id) {
        return sysPermissionMapper.selectByPrimaryKey(Long.valueOf(id));
    }

    @Override
    public void deleteSysPermissionById(Integer id) { sysPermissionMapper.deleteByPrimaryKey(Long.valueOf(id)); }

    @Override
    public void addSysPermission(SysPermission2 sysPermission) {
        sysPermissionMapper.insert(sysPermission);
    }

    @Override
    public List<SysPermission2> findAllSysPermission() {
        SysPermission2Example sysPermissionExample = new SysPermission2Example();
        SysPermission2Example.Criteria criteria = sysPermissionExample.createCriteria();
        criteria.andIdIsNotNull();
        return sysPermissionMapper.selectByExample(sysPermissionExample);
    }

    @Override
    public void updateSysPermission(SysPermission2 sysPermission) {
        SysPermission2Example sysPermissionExample = new SysPermission2Example();
        SysPermission2Example.Criteria criteria = sysPermissionExample.createCriteria();
        criteria.andIdEqualTo(sysPermission.getId());
        sysPermissionMapper.updateByExampleSelective(sysPermission,sysPermissionExample);
    }

    @Override
    public List<SysPermission2> getAllPermissionByUid(Integer uid) {
        return sysPermissionMapper.getAllPermissionByUid(uid);
    }
}
