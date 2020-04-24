package com.zjt.user_service9002.controller;

import com.zjt.common.entity.SysPermission2;
import com.zjt.common.entity.SysRole2;
import com.zjt.common.inter.SysPermission2Mapper;
import com.zjt.common.inter.SysRole2Mapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "TestController", description = "测试")
@Controller
public class Controller2 {
    private final Logger logger = LoggerFactory.getLogger(SysPermissionController.class);
    @Autowired
    private SysRole2Mapper sysUserRole2Mapper;
    @Autowired
    private SysPermission2Mapper sysPermission2Mapper;

    @ApiOperation(value = "测试获取角色")
    @RequestMapping("/tes/role")
    @ResponseBody
    public Object deleteSysPermission() {
        List<SysRole2> userRoles2 = sysUserRole2Mapper.getUserRoleIdsByUid(16);
        return userRoles2;
    }
    @ApiOperation(value = "测试获取角色id")
    @RequestMapping("/tes/roleid")
    @ResponseBody
    public Object deleteSysPermission2() {
        List<Integer> allRoleIds = sysUserRole2Mapper.getUserRolesByUid(16);
        return allRoleIds;
    }
    @ApiOperation(value = "测试获取角色权限")
    @RequestMapping("/tes/permission")
    @ResponseBody
    public Object deleteSysPermission22() {
        List<SysPermission2> allRoleIds = sysPermission2Mapper.getAllPermissionByUid(16);
        return allRoleIds;
    }

}