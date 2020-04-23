package com.zjt.user_service9001.controller;

import com.zjt.common.entity.SysUserRole2;
import com.zjt.common.entity.SysUserRole2;
import com.zjt.user_service9001.service.SysRolePermissionService;
import com.zjt.user_service9001.service.SysUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "UserRoleController", description = "用户角色管理")
@Controller
public class SysUserRoleController {
    private final Logger logger = LoggerFactory.getLogger(SysUserRoleController.class);
    @Autowired
    private SysUserRoleService sysRolePermissionService;

    @ApiOperation(value = "根据id删除角色")
    @RequestMapping("/userrole/delete/{uid}")
    public void deleteSysUserRole2(@PathVariable @ApiParam("权限id") Integer uid){
        sysRolePermissionService.deleSysUserRole2(uid);
    }

    @ApiOperation(value = "添加角色")
    @RequestMapping("/userrole/add/")
    public void addSysUserRole2(@ApiParam("权限实体") SysUserRole2 sysPermission){ sysRolePermissionService.addSysUserRole2(sysPermission); }

    @ApiOperation(value = "修改角色权限")
    @RequestMapping("/userrole/update/")
    public void updateSysUserRole2(@ApiParam("角色权限实体")  SysUserRole2 sysPermission){ sysRolePermissionService.updateSysUserRole2(sysPermission); }

    @ApiOperation(value = "列出所有用户角色")
    @ResponseBody
    @RequestMapping("/userrole/findall/")
    public List<SysUserRole2> updateSysUserRole2( ){ return sysRolePermissionService.findSysUserRole2(); }

    @ApiOperation(value = "根据id查询用户角色")
    @ResponseBody
    @RequestMapping("/userrole/find/{id}")
    public SysUserRole2 getSysUserRole2ById(@PathVariable Integer id){ return sysRolePermissionService.getSysUserRole2ById(id); }

}
