package com.zjt.interservice.inter;

import com.zjt.common.entity.SysPermission2;
import com.zjt.common.handler.CommonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Component
@FeignClient(value = "userservice")
public interface SysPermissionInter {
    @ApiOperation(value = "根据id删除权限")
    @RequestMapping("/syspermission/delete/{uid}")
    public CommonResult deleteSysPermission(@PathVariable @ApiParam("权限id") Integer uid);

    @ApiOperation(value = "添加权限")
    @RequestMapping("/syspermission/add/")
    public CommonResult addSysPermission(@ApiParam("权限实体") SysPermission2 sysPermission);

    @ApiOperation(value = "修改权限")
    @RequestMapping("/syspermission/update/")
    public CommonResult updateSysPermission(@ApiParam("权限实体")  SysPermission2 sysPermission);

    @ApiOperation(value = "列出所有权限")
    @ResponseBody
    @RequestMapping("/syspermission/findall/")
    public CommonResult updateSysPermission(@ApiParam("页码") @RequestParam Integer pageIndex, @ApiParam("条数") @RequestParam  Integer PageSize);


    @ApiOperation(value = "根据id查询权限")
    @ResponseBody
    @RequestMapping("/syspermission/find/{id}")
    public CommonResult getSysPermissionById(@PathVariable Integer id);
}
