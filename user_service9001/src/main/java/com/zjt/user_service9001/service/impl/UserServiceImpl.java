package com.zjt.user_service9001.service.impl;

import com.zjt.common.entity.SysUser2;
import com.zjt.common.entity.SysUser2Example;
import com.zjt.common.inter.SysUser2Mapper;
import com.zjt.user_service9001.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUser2Mapper sysUserMapper;

    @Override
    public void addUser(SysUser2 sysUser) {
        sysUserMapper.insert(sysUser);
    }

    @Override
    public void deleUser(Integer uid) {
        sysUserMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public void updateUser(SysUser2 sysUser) {

        SysUser2Example sysUserExample = new SysUser2Example();
        SysUser2Example.Criteria criteria = sysUserExample.createCriteria();
        criteria.andIdEqualTo(sysUser.getId());
        sysUserMapper.updateByExampleSelective(sysUser,sysUserExample);
    }

    @Override
    public List<SysUser2> findUser() {
        SysUser2Example sysUserExample = new SysUser2Example();
        SysUser2Example.Criteria criteria = sysUserExample.createCriteria();
        criteria.andIdIsNotNull();
        return sysUserMapper.selectByExample(sysUserExample);
    }

    @Override
    public SysUser2 getUserById(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysUser2 getUserByUsername(String username) {

        SysUser2Example sysUserExample = new SysUser2Example();
        SysUser2Example.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return sysUserMapper.selectByExample(sysUserExample).get(0);
    }
}
