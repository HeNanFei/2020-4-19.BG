package com.zjt.interservice.inter;

import com.zjt.common.entity.SysRolePermission2;
import com.zjt.common.handler.CommonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@FeignClient(value = "userservice")
public interface SysRolePermissionInter {
    @ApiOperation(value = "根据id删除角色权限")
    @RequestMapping("/sysrolepermission/delete/{uid}")
    public CommonResult deleteSysRolePermission2(@PathVariable @ApiParam("权限id") Integer uid);

    @ApiOperation(value = "添加角色权限")
    @RequestMapping("/SysRolePermission2/add/")
    public CommonResult addSysRolePermission2(@ApiParam("权限实体") SysRolePermission2 sysPermission);

    @ApiOperation(value = "修改角色权限")
    @RequestMapping("/SysRolePermission2/update/")
    public CommonResult updateSysRolePermission2(@ApiParam("角色权限实体")  SysRolePermission2 sysPermission);

    @ApiOperation(value = "列出所有角色权限")
    @ResponseBody
    @RequestMapping("/SysRolePermission2/findall/")
    public CommonResult updateSysRolePermission2( );

    @ApiOperation(value = "根据id查询角色权限")
    @ResponseBody
    @RequestMapping("/SysRolePermission2/find/{id}")
    public CommonResult getSysRolePermission2ById(@PathVariable Integer id);
}
