package com.zjt.interservice.controller;

import com.zjt.common.entity.SysPermission2;
import com.zjt.common.handler.CommonResult;
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
    public CommonResult deleteSysPermission(@PathVariable @ApiParam("权限id") Integer uid){
        return sysPermissionInter.deleteSysPermission(uid);
    }

    @ApiOperation(value = "添加权限")
    @RequestMapping("/SysPermission/add/")
    public CommonResult addSysPermission(@ApiParam("权限实体")  SysPermission2 sysPermission){ return sysPermissionInter.addSysPermission(sysPermission); }

    @ApiOperation(value = "修改权限")
    @RequestMapping("/SysPermission/update/")
    public CommonResult updateSysPermission(@ApiParam("权限实体")  SysPermission2 sysPermission){ return sysPermissionInter.updateSysPermission(sysPermission); }

    @ApiOperation(value = "列出所有权限")
    @ResponseBody
    @RequestMapping("/SysPermission/findall/")
    public CommonResult updateSysPermission( ){ return sysPermissionInter.updateSysPermission(); }

    @ApiOperation(value = "根据id查询权限")
    @ResponseBody
    @RequestMapping("/SysPermission/find/{id}")
    public CommonResult getSysPermissionById(@PathVariable Integer id){ return sysPermissionInter.getSysPermissionById(id); }

}
