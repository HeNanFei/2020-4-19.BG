package com.zjt.user_service9002.controller;

import com.zjt.common.entity.SysPermission2;
import com.zjt.user_service9002.service.SysPermissionService;
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

@Api(tags = "SysPermissionController", description = "权限管理")
@Controller
public class SysPermissionController {
    private final Logger logger = LoggerFactory.getLogger(SysPermissionController.class);
    @Autowired
    private SysPermissionService sysPermissionService;

    @ApiOperation(value = "根据id删除权限")
    @RequestMapping("/syspermission/delete/{uid}")
    public void deleteSysPermission(@PathVariable @ApiParam("权限id") Integer uid){
        sysPermissionService.deleteSysPermissionById(uid);
    }

    @ApiOperation(value = "添加权限")
    @RequestMapping("/SysPermission/add/")
    public void addSysPermission(@ApiParam("权限实体")  SysPermission2 sysPermission){ sysPermissionService.addSysPermission(sysPermission); }

    @ApiOperation(value = "修改权限")
    @RequestMapping("/SysPermission/update/")
    public void updateSysPermission(@ApiParam("权限实体")  SysPermission2 sysPermission){ sysPermissionService.updateSysPermission(sysPermission); }

    @ApiOperation(value = "列出所有权限")
    @ResponseBody
    @RequestMapping("/SysPermission/findall/")
    public List< SysPermission2> updateSysPermission( ){ return sysPermissionService.findAllSysPermission(); }

    @ApiOperation(value = "根据id查询权限")
    @ResponseBody
    @RequestMapping("/SysPermission/find/{id}")
    public SysPermission2 getSysPermissionById(@PathVariable Integer id){ return sysPermissionService.findSysPermissionById(id); }



}
