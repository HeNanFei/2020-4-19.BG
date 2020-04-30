package com.zjt.interservice.controller;

import com.zjt.common.entity.SysUserRole2;
import com.zjt.common.handler.CommonResult;
import com.zjt.interservice.inter.SysUserRoleInter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysUserRoleController {
    @Autowired
    private SysUserRoleInter sysUserRoleInter;

    @ApiOperation(value = "根据id删除角色")
    @RequestMapping("/userrole/delete/{uid}")
    public CommonResult deleteSysUserRole2(@PathVariable @ApiParam("权限id") Integer uid){
        return sysUserRoleInter.deleteSysUserRole2(uid);
    }

    @ApiOperation(value = "添加角色")
    @RequestMapping("/userrole/add/")
    public CommonResult addSysUserRole2(@ApiParam("权限实体") SysUserRole2 sysPermission){ return sysUserRoleInter.addSysUserRole2(sysPermission); }

    @ApiOperation(value = "修改角色权限")
    @RequestMapping("/userrole/update/")
    public CommonResult updateSysUserRole2(@ApiParam("角色权限实体")  SysUserRole2 sysPermission){ return sysUserRoleInter.updateSysUserRole2(sysPermission); }

    @ApiOperation(value = "列出所有用户角色")
    @ResponseBody
    @RequestMapping("/userrole/findall/")
    public CommonResult updateSysUserRole2( ){ return sysUserRoleInter.updateSysUserRole2(); }

    @ApiOperation(value = "根据id查询用户角色")
    @ResponseBody
    @RequestMapping("/userrole/find/{id}")
    public CommonResult getSysUserRole2ById(@PathVariable Integer id){ return sysUserRoleInter.getSysUserRole2ById(id); }


}
