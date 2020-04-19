package com.zjt.user_service9001.service;

import com.zjt.common.entity.SysRole2;
import com.zjt.common.entity.SysUser2;

import java.util.List;

public interface SysRoleService {

    void addRole2(SysRole2 sysRole2);

    void deleRole2(Integer uid);

    void updateRole2(SysRole2 sysRole2);

    List<SysRole2> findRole2();

    SysRole2 getRole2ById(long id);

    SysRole2 getRole2ByRole2name(String Role2name);



}
