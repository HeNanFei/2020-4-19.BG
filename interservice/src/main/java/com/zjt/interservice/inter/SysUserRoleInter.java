package com.zjt.interservice.inter;

import com.zjt.common.entity.SysUserRole2;
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
public interface SysUserRoleInter {

    @ApiOperation(value = "根据id删除角色")
    @RequestMapping("/userrole/delete/{uid}")
    public CommonResult deleteSysUserRole2(@PathVariable @ApiParam("权限id") Integer uid);

    @ApiOperation(value = "添加角色")
    @RequestMapping("/userrole/add/")
    public CommonResult addSysUserRole2(@ApiParam("权限实体") SysUserRole2 sysPermission);

    @ApiOperation(value = "修改角色权限")
    @RequestMapping("/userrole/update/")
    public CommonResult updateSysUserRole2(@ApiParam("角色权限实体")  SysUserRole2 sysPermission);

    @ApiOperation(value = "列出所有用户角色")
    @ResponseBody
    @RequestMapping("/userrole/findall/")
    public CommonResult updateSysUserRole2( );

    @ApiOperation(value = "根据id查询用户角色")
    @ResponseBody
    @RequestMapping("/userrole/find/{id}")
    public CommonResult getSysUserRole2ById(@PathVariable Integer id);
}
