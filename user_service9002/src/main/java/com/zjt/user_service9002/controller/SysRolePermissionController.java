package com.zjt.user_service9002.controller;

import com.zjt.common.entity.SysRolePermission2;
import com.zjt.user_service9002.service.SysRolePermissionService;
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

@Api(tags = "SysRolePermissionController", description = "角色权限管理")
@Controller
public class SysRolePermissionController {
    private final Logger logger = LoggerFactory.getLogger(SysRolePermissionController.class);
    @Autowired
    private SysRolePermissionService sysRolePermissionService;

    @ApiOperation(value = "根据id删除角色权限")
    @RequestMapping("/sysrolepermission/delete/{uid}")
    public void deleteSysRolePermission2(@PathVariable @ApiParam("权限id") Integer uid){
        sysRolePermissionService.deleSysRolePermission2(uid);
    }

    @ApiOperation(value = "添加角色权限")
    @RequestMapping("/SysRolePermission2/add/")
    public void addSysRolePermission2(@ApiParam("权限实体") SysRolePermission2 sysPermission){ sysRolePermissionService.addSysRolePermission2(sysPermission); }

    @ApiOperation(value = "修改角色权限")
    @RequestMapping("/SysRolePermission2/update/")
    public void updateSysRolePermission2(@ApiParam("角色权限实体")  SysRolePermission2 sysPermission){ sysRolePermissionService.updateSysRolePermission2(sysPermission); }

    @ApiOperation(value = "列出所有角色权限")
    @ResponseBody
    @RequestMapping("/SysRolePermission2/findall/")
    public List< SysRolePermission2> updateSysRolePermission2( ){ return sysRolePermissionService.findSysRolePermission2(); }

    @ApiOperation(value = "根据id查询角色权限")
    @ResponseBody
    @RequestMapping("/SysRolePermission2/find/{id}")
    public SysRolePermission2 getSysRolePermission2ById(@PathVariable Integer id){ return sysRolePermissionService.getSysRolePermission2ById(id); }

}
