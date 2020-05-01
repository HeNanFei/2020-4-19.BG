package com.zjt.user_service9001.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjt.common.entity.SysPermission2;
import com.zjt.common.entity.SysUser2;
import com.zjt.common.entity.SysUser2Example;
import com.zjt.common.inter.SysPermission2Mapper;
import com.zjt.common.inter.SysUser2Mapper;
import com.zjt.security.utils.JwtTokenUtil;
import com.zjt.user_service9001.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private SysUser2Mapper sysUserMapper;

    @Autowired
    private SysPermission2Mapper sysPermission2Mapper;

    @Override
    public int addUser(SysUser2 sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    @Override
    public int deleUser(Integer uid) {
        return sysUserMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public int updateUser(SysUser2 sysUser) {

        SysUser2Example sysUserExample = new SysUser2Example();
        SysUser2Example.Criteria criteria = sysUserExample.createCriteria();
        criteria.andIdEqualTo(sysUser.getId());
        return sysUserMapper.updateByExampleSelective(sysUser,sysUserExample);
    }

    @Override
    public List<SysUser2> findUser() {
        SysUser2Example sysUserExample = new SysUser2Example();
        SysUser2Example.Criteria criteria = sysUserExample.createCriteria();
        criteria.andIdIsNotNull();
        return sysUserMapper.selectByExample(sysUserExample);
    }
    @Override
    public List<SysUser2> findUser(Integer pageIndex,Integer pageSize) {
        SysUser2Example sysUserExample = new SysUser2Example();
        SysUser2Example.Criteria criteria = sysUserExample.createCriteria();
        criteria.andIdIsNotNull();
        PageHelper.startPage(pageIndex,pageSize);
        List<SysUser2> sysUser2s = sysUserMapper.selectByExample(sysUserExample);
        PageInfo<SysUser2> pageInfo = new PageInfo<>(sysUser2s);

        return pageInfo.getList();
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

    @Override
    public Map checkUser(String username,String password) {

        Map map = new HashMap();
        try {
            SysUser2 userByUsername = this.getUserByUsername(username);
            List<SysPermission2> allPermissionByUid = sysPermission2Mapper.getAllPermissionByUid(userByUsername.getId());

            ArrayList<GrantedAuthority> list = new ArrayList<>();
            list.stream().forEach(n -> list.add(new SimpleGrantedAuthority(n.getAuthority())));
            String s = jwtTokenUtil.generateToken(new User(userByUsername.getUsername(), userByUsername.getPassword(), list));
            boolean checkpw = BCrypt.checkpw(password, userByUsername.getPassword());
            if(checkpw) {
                map.put("result", checkpw);
                map.put("token", s);
            }else{
                map.put("result", false);

            }
        }catch (Exception e){

        }

        return map;
    }
}
