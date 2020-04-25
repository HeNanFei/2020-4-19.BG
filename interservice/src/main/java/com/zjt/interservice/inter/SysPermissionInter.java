package com.zjt.interservice.inter;

import com.zjt.common.entity.SysPermission2;
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
public interface SysPermissionInter {
    @ApiOperation(value = "根据id删除权限")
    @RequestMapping("/syspermission/delete/{uid}")
    public void deleteSysPermission(@PathVariable @ApiParam("权限id") Integer uid);

    @ApiOperation(value = "添加权限")
    @RequestMapping("/SysPermission/add/")
    public void addSysPermission(@ApiParam("权限实体") SysPermission2 sysPermission);

    @ApiOperation(value = "修改权限")
    @RequestMapping("/SysPermission/update/")
    public void updateSysPermission(@ApiParam("权限实体")  SysPermission2 sysPermission);

    @ApiOperation(value = "列出所有权限")
    @ResponseBody
    @RequestMapping("/SysPermission/findall/")
    public List< SysPermission2> updateSysPermission( );

    @ApiOperation(value = "根据id查询权限")
    @ResponseBody
    @RequestMapping("/SysPermission/find/{id}")
    public SysPermission2 getSysPermissionById(@PathVariable Integer id);
}
