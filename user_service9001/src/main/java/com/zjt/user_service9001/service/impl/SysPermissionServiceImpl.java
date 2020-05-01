package com.zjt.user_service9001.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjt.common.entity.SysPermission2;
import com.zjt.common.entity.SysPermission2Example;

import com.zjt.common.inter.SysPermission2Mapper;

import com.zjt.user_service9001.service.SysPermissionService;
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
    public int deleteSysPermissionById(Integer id) { return sysPermissionMapper.deleteByPrimaryKey(Long.valueOf(id)); }

    @Override
    public int addSysPermission(SysPermission2 sysPermission) {
        return sysPermissionMapper.insert(sysPermission);
    }

    @Override
    public List<SysPermission2> findAllSysPermission(Integer pageIndex,Integer PageSize) {
        SysPermission2Example sysPermissionExample = new SysPermission2Example();
        SysPermission2Example.Criteria criteria = sysPermissionExample.createCriteria();
        criteria.andIdIsNotNull();
        PageHelper.startPage(pageIndex,PageSize);
        List<SysPermission2> sysPermission2s = sysPermissionMapper.selectByExample(sysPermissionExample);
        PageInfo<SysPermission2> pageInfo = new PageInfo<>(sysPermission2s);
        List<SysPermission2> list = pageInfo.getList();
        return list;
    }

    @Override
    public int updateSysPermission(SysPermission2 sysPermission) {
        SysPermission2Example sysPermissionExample = new SysPermission2Example();
        SysPermission2Example.Criteria criteria = sysPermissionExample.createCriteria();
        criteria.andIdEqualTo(sysPermission.getId());
        return sysPermissionMapper.updateByExampleSelective(sysPermission,sysPermissionExample);
    }

    @Override
    public List<SysPermission2> getAllPermissionByUid(Integer uid) {
        return sysPermissionMapper.getAllPermissionByUid(uid);
    }

    @Override
    public List<SysPermission2> findAllSysPermission() {
        SysPermission2Example sysPermissionExample = new SysPermission2Example();
        SysPermission2Example.Criteria criteria = sysPermissionExample.createCriteria();
        criteria.andIdIsNotNull();

        return sysPermissionMapper.selectByExample(sysPermissionExample);

    }
}
