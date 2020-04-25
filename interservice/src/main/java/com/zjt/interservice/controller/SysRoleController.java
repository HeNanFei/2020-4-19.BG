package com.zjt.interservice.controller;

import com.zjt.common.entity.SysRole2;
import com.zjt.interservice.inter.SysRoleInter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SysRoleController {
    @Autowired
    private SysRoleInter sysRoleInter;
    @ApiOperation(value = "根据id删除角色")
    @RequestMapping("/role/delete/{uid}")
    public void deleteSysRole2(@PathVariable @ApiParam("角色id") Integer uid){
        sysRoleInter.deleteSysRole2(uid);
    }

    @ApiOperation(value = "添加角色")
    @RequestMapping("/role/add/")
    public void addSysRole2(@ApiParam("角色实体") SysRole2 role){ sysRoleInter.addSysRole2(role); }

    @ApiOperation(value = "修改角色")
    @RequestMapping("/role/update/")
    public void updateSysRole2(@ApiParam("角色实体") SysRole2 role){ sysRoleInter.updateSysRole2(role); }

    @ApiOperation(value = "列出所有角色")
    @ResponseBody
    @RequestMapping("/role/findall/")
    public List<SysRole2> updateSysRole2( ){ return sysRoleInter.updateSysRole2(); }

    @ApiOperation(value = "根据id查询角色")
    @ResponseBody
    @RequestMapping("/role/find/{id}")
    public SysRole2 getSysRole2ById(@PathVariable long id){ return sysRoleInter.getSysRole2ById(id); }

    @ApiOperation(value = "根据姓名查询角色")
    @ResponseBody
    @RequestMapping("/role/find/name/{rolename}")
    public SysRole2 getSysRole2ByName(@PathVariable String rolename){ return sysRoleInter.getSysRole2ByName(rolename); }

}
