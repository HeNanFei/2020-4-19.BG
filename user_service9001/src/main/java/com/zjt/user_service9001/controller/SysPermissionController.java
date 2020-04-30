package com.zjt.user_service9001.controller;

import com.zjt.common.entity.SysPermission2;

import com.zjt.common.handler.CommonResult;
import com.zjt.user_service9001.service.SysPermissionService;
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
    public CommonResult deleteSysPermission(@PathVariable @ApiParam("权限id") Integer uid){
        int i = sysPermissionService.deleteSysPermissionById(uid);
        if(i == 0){
            return CommonResult.failed(null,"删除失败");
        }else{
            return  CommonResult.success(null,"删除成功");
        }
    }

    @ApiOperation(value = "添加权限")
    @RequestMapping("/SysPermission/add/")
    public CommonResult addSysPermission(@ApiParam("权限实体")  SysPermission2 sysPermission){
        int i = sysPermissionService.addSysPermission(sysPermission);
        if(i == 0){
            return CommonResult.failed("添加失败");
        }else{
            return CommonResult.success("添加成功");
        }
    }

    @ApiOperation(value = "修改权限")
    @RequestMapping("/SysPermission/update/")
    public CommonResult updateSysPermission(@ApiParam("权限实体")  SysPermission2 sysPermission){
        int i = sysPermissionService.updateSysPermission(sysPermission);
        if(i == 0){
            return CommonResult.failed("更新失败");
        }else{
            return CommonResult.success("update success");
        }
    }

    @ApiOperation(value = "列出所有权限")
    @ResponseBody
    @RequestMapping("/SysPermission/findall/")
    public CommonResult updateSysPermission( ){
        List<SysPermission2> allSysPermission = sysPermissionService.findAllSysPermission();
        if(allSysPermission  == null){
            return  CommonResult.failed("value is null");
        }else{
            return  CommonResult.success(allSysPermission);
        }
    }

    @ApiOperation(value = "根据id查询权限")
    @ResponseBody
    @RequestMapping("/SysPermission/find/{id}")
    public CommonResult getSysPermissionById(@PathVariable Integer id){
        SysPermission2 sysPermissionById = sysPermissionService.findSysPermissionById(id);
        if(sysPermissionById == null){
            return  CommonResult.failed("value is null");
        }else{
            return  CommonResult.success(sysPermissionById);
        }
    }



}
