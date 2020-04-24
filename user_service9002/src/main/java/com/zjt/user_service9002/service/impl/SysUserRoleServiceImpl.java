package com.zjt.user_service9002.service.impl;

import com.zjt.common.entity.SysUserRole2;
import com.zjt.common.entity.SysUserRole2Example;
import com.zjt.common.inter.SysUserRole2Mapper;
import com.zjt.user_service9002.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private SysUserRole2Mapper sysSysUserRole2Mapper;

    @Override
    public void addSysUserRole2(SysUserRole2 sysSysUserRole2) {
        sysSysUserRole2Mapper.insert(sysSysUserRole2);
    }

    @Override
    public void deleSysUserRole2(Integer uid) {
        sysSysUserRole2Mapper.deleteByPrimaryKey(String.valueOf(uid));
    }

    @Override
    public void updateSysUserRole2(SysUserRole2 sysSysUserRole2) {

        SysUserRole2Example sysSysUserRole2Example = new SysUserRole2Example();
        SysUserRole2Example.Criteria criteria = sysSysUserRole2Example.createCriteria();
        criteria.andIdEqualTo(sysSysUserRole2.getId());
        sysSysUserRole2Mapper.updateByExampleSelective(sysSysUserRole2,sysSysUserRole2Example);
    }

    @Override
    public List<SysUserRole2> findSysUserRole2() {
        SysUserRole2Example sysSysUserRole2Example = new SysUserRole2Example();
        SysUserRole2Example.Criteria criteria = sysSysUserRole2Example.createCriteria();
        criteria.andIdIsNotNull();
        return sysSysUserRole2Mapper.selectByExample(sysSysUserRole2Example);
    }

    @Override
    public SysUserRole2 getSysUserRole2ById(Integer id) {
        return sysSysUserRole2Mapper.selectByPrimaryKey(String.valueOf(id));
    }

    @Override
    public SysUserRole2 getSysUserRole2BySysUserRole2name(String username) {

        SysUserRole2Example sysSysUserRole2Example = new SysUserRole2Example();
        SysUserRole2Example.Criteria criteria = sysSysUserRole2Example.createCriteria();
        criteria.andIdEqualTo(username);
        return sysSysUserRole2Mapper.selectByExample(sysSysUserRole2Example).get(0);
    }
}
