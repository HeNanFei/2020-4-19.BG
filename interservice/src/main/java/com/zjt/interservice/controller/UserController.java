package com.zjt.interservice.controller;

import com.zjt.common.entity.SysUser2;
import com.zjt.interservice.inter.UserInter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserInter userInter;
    @ApiOperation(value = "根据id删除用户")
    @RequestMapping("/user/delete/{uid}")
    public void deleteUser(@PathVariable @ApiParam("用户id") Integer uid){
        userInter.deleteUser(uid);
    }

    @ApiOperation(value = "添加用户")
    @RequestMapping("/user/add/")
    public void addUser(@ApiParam("用户实体") SysUser2 user){ userInter.addUser(user); }

    @ApiOperation(value = "修改用户")
    @RequestMapping("/user/update/")
    public void updateUser(@ApiParam("用户实体") SysUser2 user){ userInter.updateUser(user); }

    @ApiOperation(value = "列出所有用户")
    @ResponseBody
    @RequestMapping("/user/findall/")
    public List<SysUser2> findAllUser( ){ return userInter.findAllUser(); }

    @ApiOperation(value = "根据id查询用户")
    @ResponseBody
    @RequestMapping("/user/find/{id}")
    public SysUser2 getUserById(@PathVariable Integer id){ return userInter.getUserById(id); }

    @ApiOperation(value = "根据姓名查询用户")
    @ResponseBody
    @RequestMapping("/user/find/name/{username}")
    public SysUser2 getUserByName(@PathVariable String username){ return userInter.getUserByName(username); }

    @ApiOperation(value = "前端用户检测")
    @ResponseBody
    @RequestMapping("/check/result")
    public Map getUserByName(SysUser2 sysUser2){
        Map map = userInter.checkUserByInfor(sysUser2);

        return map;
    }


}
