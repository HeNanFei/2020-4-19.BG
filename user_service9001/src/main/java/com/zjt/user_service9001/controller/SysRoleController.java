package com.zjt.user_service9001.controller;

import com.zjt.common.entity.SysRole2;
import com.zjt.user_service9001.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.WebBindingInitializer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(tags = "SysRoleController", description = "角色管理")
@Controller
public class SysRoleController  implements WebBindingInitializer {
    private final Logger logger = LoggerFactory.getLogger(SysRoleController.class);
    @Autowired
    private SysRoleService roleService;

    @ApiOperation(value = "根据id删除角色")
    @RequestMapping("/role/delete/{uid}")
    public void deleteSysRole2(@PathVariable @ApiParam("角色id") Integer uid){
        roleService.deleRole2(uid);
    }

    @ApiOperation(value = "添加角色")
    @RequestMapping("/role/add/")
    public void addSysRole2(@ApiParam("角色实体") SysRole2 role){ roleService.addRole2(role); }

    @ApiOperation(value = "修改角色")
    @RequestMapping("/role/update/")
    public void updateSysRole2(@ApiParam("角色实体") SysRole2 role){ roleService.updateRole2(role); }

    @ApiOperation(value = "列出所有角色")
    @ResponseBody
    @RequestMapping("/role/findall/")
    public List<SysRole2> updateSysRole2( ){ return roleService.findRole2(); }

    @ApiOperation(value = "根据id查询角色")
    @ResponseBody
    @RequestMapping("/role/find/{id}")
    public SysRole2 getSysRole2ById(@PathVariable long id){ return roleService.getRole2ById(id); }

    @ApiOperation(value = "根据姓名查询角色")
    @ResponseBody
    @RequestMapping("/role/find/{rolename}")
    public SysRole2 getSysRole2ByName(@PathVariable String rolename){ return roleService.getRole2ByRole2name(rolename); }

    @Override
    public void initBinder(WebDataBinder webDataBinder) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }




}

