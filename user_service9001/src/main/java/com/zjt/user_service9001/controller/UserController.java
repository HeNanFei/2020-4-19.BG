package com.zjt.user_service9001.controller;

import com.zjt.common.entity.SysUser2;
import com.zjt.common.handler.ApiException;
import com.zjt.common.handler.CommonResult;
import com.zjt.common.handler.GlobalExceptionHandler;
import com.zjt.common.handler.ResultCode;
import com.zjt.user_service9001.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Api(tags = "UserController", description = "用户管理")
@Controller
public class UserController  implements WebBindingInitializer {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据id删除用户")
    @RequestMapping("/user/delete/")
    public CommonResult deleteUser2(@PathVariable @ApiParam("用户uid") @RequestParam Integer uid){
        int i = userService.deleUser(uid);

        if(i == 0){
            return CommonResult.failed(null,"删除失败");
        }else{
            return  CommonResult.success(null,"删除成功");
        }
    }

    @ApiOperation(value = "添加用户")
    @RequestMapping("/user/add/")
    public CommonResult addUser(@ApiParam("用户实体") @RequestParam SysUser2 user){
        int i = userService.addUser(user);
        if(i == 0){
            return CommonResult.failed("添加失败");
        }else{
            return CommonResult.success("添加成功");
        }

    }

    @ApiOperation(value = "修改用户")
    @RequestMapping("/user/update/")
    public CommonResult updateUser(@ApiParam("用户实体") @RequestParam SysUser2 user){
        int i = userService.updateUser(user);
        if(i == 0){
            return CommonResult.failed("更新失败");
        }else{
            return CommonResult.success("update success");
        }
    }

    @ApiOperation(value = "列出所有用户")
    @ResponseBody
    @RequestMapping("/user/findall/")
    public CommonResult findAllUser(@ApiParam("页码") @RequestParam  Integer pageIndex,@ApiParam("条数") @RequestParam  Integer pageSize){
        List<SysUser2> user = userService.findUser(pageIndex,pageSize);
        if(user  == null){
            return  CommonResult.failed("value is null");
        }else{
            return  CommonResult.success(user);
        }

    }

    @ApiOperation(value = "根据id查询用户")
    @ResponseBody
    @RequestMapping("/user/find/{id}")
    public CommonResult getUserById(@PathVariable @RequestParam Integer id){
        SysUser2 userById = userService.getUserById(id);
        if(userById == null){
            return  CommonResult.failed("value is null");
        }else{
            return  CommonResult.success(userById);
        }
    }


    @ApiOperation(value = "根据姓名查询用户")
    @ResponseBody
    @RequestMapping("/user/find/name/{username}")
    public CommonResult getUserByName(@PathVariable @RequestParam String username){

        SysUser2 userByUsername = userService.getUserByUsername(username);
        if(userByUsername == null){
                return  CommonResult.failed("value is null");
            }else{
                return  CommonResult.success(userByUsername);
            }
        }

    @ApiOperation(value = "前端用户检测")
    @ResponseBody
    @RequestMapping("/check/result")
    public CommonResult checkUserByInfor(@RequestParam String username, @RequestParam String password){
        Map map = userService.checkUser(username,password);
        if(map.get("result") == null){
            return CommonResult.validateFailed();
        }else {
            return CommonResult.success(map);
        }
    }

    @Override
    public void initBinder(WebDataBinder webDataBinder) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }




}
