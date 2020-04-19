package com.zjt.user_service9001.service.impl;

import com.zjt.common.entity.SysRole2;
import com.zjt.common.entity.SysRole2Example;
import com.zjt.common.inter.SysRole2Mapper;
import com.zjt.user_service9001.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRole2Mapper sysRole2Mapper;

    @Override
    public void addRole2(SysRole2 sysRole2) {
        sysRole2Mapper.insert(sysRole2);
    }

    @Override
    public void deleRole2(Integer uid) {
        sysRole2Mapper.deleteByPrimaryKey(String.valueOf(uid));
    }

    @Override
    public void updateRole2(SysRole2 sysRole2) {
        SysRole2Example sysRole2Example = new SysRole2Example();
        SysRole2Example.Criteria criteria = sysRole2Example.createCriteria();
        criteria.andIdEqualTo(sysRole2.getId());

        sysRole2Mapper.updateByExampleSelective(sysRole2,sysRole2Example);
    }

    @Override
    public List<SysRole2> findRole2() {
        SysRole2Example sysRole2Example = new SysRole2Example();
        SysRole2Example.Criteria criteria = sysRole2Example.createCriteria();
        criteria.andIdIsNotNull();
        return sysRole2Mapper.selectByExample(sysRole2Example);
    }

    @Override
    public SysRole2 getRole2ById(long id) {
        return sysRole2Mapper.selectByPrimaryKey(String.valueOf(id));
    }

    @Override
    public SysRole2 getRole2ByRole2name(String Role2name) {
        SysRole2Example sysRole2Example = new SysRole2Example();
        SysRole2Example.Criteria criteria = sysRole2Example.createCriteria();
        criteria.andNameEqualTo(Role2name);
        return sysRole2Mapper.selectByExample(sysRole2Example).get(0);
    }
}
