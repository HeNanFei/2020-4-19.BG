package com.zjt.interservice.controller;

import com.zjt.common.entity.SysRolePermission2;
import com.zjt.interservice.inter.SysRolePermissionInter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysRolePermissionController {
    @Autowired
    private SysRolePermissionInter sysRolePermissionInter;
    @ApiOperation(value = "根据id删除角色权限")
    @RequestMapping("/sysrolepermission/delete/{uid}")
    public void deleteSysRolePermission2(@PathVariable @ApiParam("权限id") Integer uid){
        sysRolePermissionInter.deleteSysRolePermission2(uid);
    }

    @ApiOperation(value = "添加角色权限")
    @RequestMapping("/SysRolePermission2/add/")
    public void addSysRolePermission2(@ApiParam("权限实体") SysRolePermission2 sysPermission){ sysRolePermissionInter.addSysRolePermission2(sysPermission); }

    @ApiOperation(value = "修改角色权限")
    @RequestMapping("/SysRolePermission2/update/")
    public void updateSysRolePermission2(@ApiParam("角色权限实体")  SysRolePermission2 sysPermission){ sysRolePermissionInter.updateSysRolePermission2(sysPermission); }

    @ApiOperation(value = "列出所有角色权限")
    @ResponseBody
    @RequestMapping("/SysRolePermission2/findall/")
    public List< SysRolePermission2> updateSysRolePermission2( ){ return sysRolePermissionInter.updateSysRolePermission2(); }

    @ApiOperation(value = "根据id查询角色权限")
    @ResponseBody
    @RequestMapping("/SysRolePermission2/find/{id}")
    public SysRolePermission2 getSysRolePermission2ById(@PathVariable Integer id){ return sysRolePermissionInter.getSysRolePermission2ById(id); }
}
