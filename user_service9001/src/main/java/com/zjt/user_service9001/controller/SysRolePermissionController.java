package com.zjt.user_service9001.controller;

import com.zjt.common.entity.SysPermission2;
import com.zjt.common.entity.SysRolePermission2;
import com.zjt.common.handler.CommonResult;
import com.zjt.user_service9001.service.SysPermissionService;
import com.zjt.user_service9001.service.SysRolePermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public CommonResult deleteSysRolePermission2(@PathVariable @ApiParam("权限id") Integer uid){
        int i = sysRolePermissionService.deleSysRolePermission2(uid);
        if(i == 0){
            return CommonResult.failed(null,"删除失败");
        }else{
            return  CommonResult.success(null,"删除成功");
        }
    }

    @ApiOperation(value = "添加角色权限")
    @RequestMapping("/SysRolePermission2/add/")
    public CommonResult addSysRolePermission2(@ApiParam("权限实体") SysRolePermission2 sysPermission){
        int i = sysRolePermissionService.addSysRolePermission2(sysPermission);
        if(i == 0){
            return CommonResult.failed(null,"添加失败");
        }else{
            return  CommonResult.success(null,"添加成功");
        }
    }

    @ApiOperation(value = "修改角色权限")
    @RequestMapping("/SysRolePermission2/update/")
    public CommonResult updateSysRolePermission2(@ApiParam("角色权限实体")  SysRolePermission2 sysPermission){
        int i = sysRolePermissionService.updateSysRolePermission2(sysPermission);
        if(i == 0){
            return CommonResult.failed("修改失败");
        }else{
            return CommonResult.success("修改成功");
        }
    }

    @ApiOperation(value = "列出所有角色权限")
    @ResponseBody
    @RequestMapping("/SysRolePermission2/findall/")
    public CommonResult updateSysRolePermission2(@ApiParam("页码") @RequestParam Integer pageIndex, @ApiParam("条数") @RequestParam  Integer pageSize){
        List<SysRolePermission2> sysRolePermission2 = sysRolePermissionService.findSysRolePermission2(pageIndex,pageSize);
        if(sysRolePermission2  == null){
            return  CommonResult.failed("value is null");
        }else{
            return  CommonResult.success(sysRolePermission2);
        }

    }

    @ApiOperation(value = "根据id查询角色权限")
    @ResponseBody
    @RequestMapping("/SysRolePermission2/find/{id}")
    public CommonResult getSysRolePermission2ById(@PathVariable Integer id){
        SysRolePermission2 sysRolePermission2ById = sysRolePermissionService.getSysRolePermission2ById(id);
        if(sysRolePermission2ById == null){
            return  CommonResult.failed("value is null");
        }else{
            return  CommonResult.success(sysRolePermission2ById);
        }
    }

}
