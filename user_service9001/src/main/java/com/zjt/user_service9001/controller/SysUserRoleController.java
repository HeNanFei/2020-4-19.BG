package com.zjt.user_service9001.controller;

import com.zjt.common.entity.SysUserRole2;
import com.zjt.common.entity.SysUserRole2;
import com.zjt.common.handler.CommonResult;
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
    public CommonResult deleteSysUserRole2(@PathVariable @ApiParam("权限id") Integer uid){
        int i = sysRolePermissionService.deleSysUserRole2(uid);
        if(i == 0){
            return CommonResult.failed(null,"删除失败");
        }else{
            return  CommonResult.success(null,"删除成功");
        }
    }

    @ApiOperation(value = "添加角色")
    @RequestMapping("/userrole/add/")
    public CommonResult addSysUserRole2(@ApiParam("权限实体") SysUserRole2 sysPermission){
        int i = sysRolePermissionService.addSysUserRole2(sysPermission);
        if(i == 0){
            return CommonResult.failed("添加失败");
        }else{
            return CommonResult.success("添加成功");
        }
    }

    @ApiOperation(value = "修改角色权限")
    @RequestMapping("/userrole/update/")
    public CommonResult updateSysUserRole2(@ApiParam("角色权限实体")  SysUserRole2 sysPermission){
        int i = sysRolePermissionService.updateSysUserRole2(sysPermission);
        if(i == 0){
            return CommonResult.failed("更新失败");
        }else{
            return CommonResult.success("update success");
        }
    }

    @ApiOperation(value = "列出所有用户角色")
    @ResponseBody
    @RequestMapping("/userrole/findall/")
    public CommonResult updateSysUserRole2( ){
        List<SysUserRole2> sysUserRole2 = sysRolePermissionService.findSysUserRole2();
        if(sysUserRole2  == null){
            return  CommonResult.failed("value is null");
        }else{
            return  CommonResult.success(sysUserRole2);
        }
    }

    @ApiOperation(value = "根据id查询用户角色")
    @ResponseBody
    @RequestMapping("/userrole/find/{id}")
    public CommonResult getSysUserRole2ById(@PathVariable Integer id){
        SysUserRole2 sysUserRole2ById = sysRolePermissionService.getSysUserRole2ById(id);
        if(sysUserRole2ById == null){
            return  CommonResult.failed("value is null");
        }else{
            return  CommonResult.success(sysUserRole2ById);
        }
    }

}
