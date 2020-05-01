package com.zjt.user_service9001.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjt.common.entity.SysRolePermission2;
import com.zjt.common.entity.SysRolePermission2Example;
import com.zjt.common.entity.SysUser2;
import com.zjt.common.entity.SysUser2Example;
import com.zjt.common.inter.SysRolePermission2Mapper;
import com.zjt.common.inter.SysUser2Mapper;
import com.zjt.user_service9001.service.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {

    @Autowired
    private SysRolePermission2Mapper sysSysRolePermission2Mapper;

    @Override
    public int addSysRolePermission2(SysRolePermission2 sysSysRolePermission2) {
        return sysSysRolePermission2Mapper.insert(sysSysRolePermission2);
    }

    @Override
    public int deleSysRolePermission2(Integer uid) {
        return sysSysRolePermission2Mapper.deleteByPrimaryKey(String.valueOf(uid));
    }

    @Override
    public int updateSysRolePermission2(SysRolePermission2 sysSysRolePermission2) {

        SysRolePermission2Example sysSysRolePermission2Example = new SysRolePermission2Example();
        SysRolePermission2Example.Criteria criteria = sysSysRolePermission2Example.createCriteria();
        criteria.andIdEqualTo(sysSysRolePermission2.getId());
        return sysSysRolePermission2Mapper.updateByExampleSelective(sysSysRolePermission2,sysSysRolePermission2Example);
    }

    @Override
    public List<SysRolePermission2> findSysRolePermission2() {
        SysRolePermission2Example sysSysRolePermission2Example = new SysRolePermission2Example();
        SysRolePermission2Example.Criteria criteria = sysSysRolePermission2Example.createCriteria();
        criteria.andIdIsNotNull();
        return sysSysRolePermission2Mapper.selectByExample(sysSysRolePermission2Example);
    }
    @Override
    public List<SysRolePermission2> findSysRolePermission2(Integer pageIndex,Integer pageSize) {
        SysRolePermission2Example sysSysRolePermission2Example = new SysRolePermission2Example();
        SysRolePermission2Example.Criteria criteria = sysSysRolePermission2Example.createCriteria();
        criteria.andIdIsNotNull();
        PageHelper.startPage(pageIndex,pageSize);
        List<SysRolePermission2> sysRolePermission2s = sysSysRolePermission2Mapper.selectByExample(sysSysRolePermission2Example);
        PageInfo<SysRolePermission2> pageInfo = new PageInfo<>(sysRolePermission2s);

        return pageInfo.getList();
    }
    @Override
    public SysRolePermission2 getSysRolePermission2ById(Integer id) {
        return sysSysRolePermission2Mapper.selectByPrimaryKey(String.valueOf(id));
    }

    @Override
    public SysRolePermission2 getSysRolePermission2BySysRolePermission2name(String username) {

        SysRolePermission2Example sysSysRolePermission2Example = new SysRolePermission2Example();
        SysRolePermission2Example.Criteria criteria = sysSysRolePermission2Example.createCriteria();
        criteria.andIdEqualTo(username);
        return sysSysRolePermission2Mapper.selectByExample(sysSysRolePermission2Example).get(0);
    }
}
