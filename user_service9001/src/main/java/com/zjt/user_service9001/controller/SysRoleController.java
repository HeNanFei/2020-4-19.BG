package com.zjt.user_service9001.controller;

import com.zjt.common.entity.SysRole2;
import com.zjt.common.handler.CommonResult;
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
import org.springframework.web.bind.annotation.RequestParam;
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
    public CommonResult deleteSysRole2(@PathVariable @ApiParam("角色id") Integer uid){
        int i = roleService.deleRole2(uid);
        if(i == 0){
            return CommonResult.failed(null,"删除失败");
        }else{
            return  CommonResult.success(null,"删除成功");
        }
    }

    @ApiOperation(value = "添加角色")
    @RequestMapping("/role/add/")
    public CommonResult  addSysRole2(@ApiParam("角色实体") SysRole2 role){
        int i = roleService.addRole2(role);
        if(i == 0){
            return CommonResult.failed("添加失败");
        }else{
            return CommonResult.success("添加成功");
        }
    }

    @ApiOperation(value = "修改角色")
    @RequestMapping("/role/update/")
    public CommonResult updateSysRole2(@ApiParam("角色实体") SysRole2 role){
        int i = roleService.updateRole2(role);
        if(i == 0){
            return CommonResult.failed("更新失败");
        }else{
            return CommonResult.success("update success");
        }

    }

    @ApiOperation(value = "列出所有角色")
    @ResponseBody
    @RequestMapping("/role/findall/")
    public CommonResult updateSysRole2(@ApiParam("页码") @RequestParam Integer pageIndex, @ApiParam("条数") @RequestParam  Integer pageSize){
        List<SysRole2> role2 = roleService.findRole2(pageIndex,pageSize);
        if(role2  == null){
            return  CommonResult.failed("value is null");
        }else{
            return  CommonResult.success(role2);
        }

    }

    @ApiOperation(value = "根据id查询角色")
    @ResponseBody
    @RequestMapping("/role/find/{id}")
    public CommonResult getSysRole2ById(@PathVariable long id){
        SysRole2 role2ById = roleService.getRole2ById(id);
        if(role2ById == null){
            return  CommonResult.failed("value is null");
        }else{
            return  CommonResult.success(role2ById);
        }
    }

    @ApiOperation(value = "根据姓名查询角色")
    @ResponseBody
    @RequestMapping("/role/find/name/{rolename}")
    public CommonResult getSysRole2ByName(@PathVariable String rolename){
        SysRole2 role2ByRole2name = roleService.getRole2ByRole2name(rolename);
        if(role2ByRole2name == null){
            return  CommonResult.failed("value is null");
        }else{
            return  CommonResult.success(role2ByRole2name);
        }
    }

    @Override
    public void initBinder(WebDataBinder webDataBinder) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }




}

