package com.zjt.interservice.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zjt.common.entity.SysUser2;
import com.zjt.common.handler.CommonResult;
import com.zjt.common.handler.GlobalSentinelHandler;
import com.zjt.interservice.inter.UserInter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserInter userInter;
    @ApiOperation(value = "根据id删除用户")
    @RequestMapping("/user/delete/")
    public CommonResult deleteUser2(@PathVariable @ApiParam("用户uid") @RequestParam Integer uid){
        return userInter.deleteUser2(uid);
    }

    @ApiOperation(value = "添加用户")
    @RequestMapping("/user/add/")
    public CommonResult addUser(@ApiParam("用户实体") @RequestParam SysUser2 user){ return userInter.addUser(user); }

    @ApiOperation(value = "修改用户")
    @RequestMapping("/user/update/")
    public CommonResult updateUser(@ApiParam("用户实体") @RequestParam SysUser2 user){ return userInter.updateUser(user); }

    @ApiOperation(value = "列出所有用户")
    @ResponseBody
    @RequestMapping("/user/findall/")
    public CommonResult findAllUser( ){ return userInter.findAllUser(); }

    @ApiOperation(value = "根据id查询用户")
    @ResponseBody
    @RequestMapping("/user/find/{id}")
    public CommonResult getUserById(@PathVariable @RequestParam Integer id){ return userInter.getUserById(id); }

    @ApiOperation(value = "根据姓名查询用户")
    @ResponseBody
    @RequestMapping("/user/find/name/{username}")
    public CommonResult getUserByName(@PathVariable @RequestParam String username){ return userInter.getUserByName(username); }


    @ApiOperation(value = "前端用户检测")
    @SentinelResource(value = "userservice",blockHandlerClass = GlobalSentinelHandler.class,blockHandler = "checkUserByInfor2")
    @ResponseBody
    @RequestMapping("/check/result")
    public CommonResult checkUserByInfor(@RequestParam String username,@RequestParam String password){


        return userInter.checkUserByInfor(username,password);
    }



}
