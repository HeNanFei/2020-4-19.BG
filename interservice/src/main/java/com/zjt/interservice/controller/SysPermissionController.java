package com.zjt.interservice.controller;

import com.zjt.common.entity.SysPermission2;
import com.zjt.interservice.inter.SysPermissionInter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysPermissionController {

    @Autowired
    private SysPermissionInter sysPermissionInter;
    @ApiOperation(value = "根据id删除权限")
    @RequestMapping("/syspermission/delete/{uid}")
    public void deleteSysPermission(@PathVariable @ApiParam("权限id") Integer uid){
        sysPermissionInter.deleteSysPermission(uid);
    }

    @ApiOperation(value = "添加权限")
    @RequestMapping("/SysPermission/add/")
    public void addSysPermission(@ApiParam("权限实体")  SysPermission2 sysPermission){ sysPermissionInter.addSysPermission(sysPermission); }

    @ApiOperation(value = "修改权限")
    @RequestMapping("/SysPermission/update/")
    public void updateSysPermission(@ApiParam("权限实体")  SysPermission2 sysPermission){ sysPermissionInter.updateSysPermission(sysPermission); }

    @ApiOperation(value = "列出所有权限")
    @ResponseBody
    @RequestMapping("/SysPermission/findall/")
    public List< SysPermission2> updateSysPermission( ){ return sysPermissionInter.updateSysPermission(); }

    @ApiOperation(value = "根据id查询权限")
    @ResponseBody
    @RequestMapping("/SysPermission/find/{id}")
    public SysPermission2 getSysPermissionById(@PathVariable Integer id){ return sysPermissionInter.getSysPermissionById(id); }



}
