package com.zjt.user_service9002.controller;

import com.zjt.common.entity.SysUser2;
import com.zjt.user_service9002.service.UserService;
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
import java.util.Map;

@Api(tags = "UserController", description = "用户管理")
@Controller
public class UserController  implements WebBindingInitializer {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据id删除用户")
    @RequestMapping("/user/delete/{uid}")
    public void deleteUser(@PathVariable @ApiParam("用户id") @RequestParam Integer uid){
        userService.deleUser(uid);
    }

    @ApiOperation(value = "添加用户")
    @RequestMapping("/user/add/")
    public void addUser(@ApiParam("用户实体") @RequestParam SysUser2 user){ userService.addUser(user); }

    @ApiOperation(value = "修改用户")
    @RequestMapping("/user/update/")
    public void updateUser(@ApiParam("用户实体") @RequestParam SysUser2 user){ userService.updateUser(user); }

    @ApiOperation(value = "列出所有用户")
    @ResponseBody
    @RequestMapping("/user/findall/")
    public List<SysUser2> findAllUser( ){ return userService.findUser(); }

    @ApiOperation(value = "根据id查询用户")
    @ResponseBody
    @RequestMapping("/user/find/{id}")
    public SysUser2 getUserById(@PathVariable @RequestParam Integer id){ return userService.getUserById(id); }

    @ApiOperation(value = "根据姓名查询用户")
    @ResponseBody
    @RequestMapping("/user/find/name/{username}")
    public SysUser2 getUserByName(@PathVariable @RequestParam String username){ return userService.getUserByUsername(username); }

    @ApiOperation(value = "前端用户检测")
    @ResponseBody
    @RequestMapping("/check/result")
    public Map checkUserByInfor(@RequestParam String username,@RequestParam String password){
        Map map = userService.checkUser(username,password);
        map.put("part2","part2");
        return map;
    }

    @Override
    public void initBinder(WebDataBinder webDataBinder) {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }




}
