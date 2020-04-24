package com.zjt.interservice.inter;

import com.zjt.common.entity.SysUser2;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
@Component
@FeignClient(value = "userservice")
public interface UserInter {


    @ApiOperation(value = "根据id删除用户")
    @RequestMapping("/user/delete/{uid}")
    public void deleteUser(@PathVariable @ApiParam("用户id") @RequestParam Integer uid);

    @ApiOperation(value = "添加用户")
    @RequestMapping("/user/add/")
    public void addUser(@ApiParam("用户实体") @RequestParam SysUser2 user);

    @ApiOperation(value = "修改用户")
    @RequestMapping("/user/update/")
    public void updateUser(@ApiParam("用户实体") @RequestParam SysUser2 user);

    @ApiOperation(value = "列出所有用户")
    @ResponseBody
    @RequestMapping("/user/findall/")
    public List<SysUser2> findAllUser( );

    @ApiOperation(value = "根据id查询用户")
    @ResponseBody
    @RequestMapping("/user/find/{id}")
    public SysUser2 getUserById(@PathVariable @RequestParam Integer id);

    @ApiOperation(value = "根据姓名查询用户")
    @ResponseBody
    @RequestMapping("/user/find/name/{username}")
    public SysUser2 getUserByName(@PathVariable @RequestParam String username);

    @ApiOperation(value = "前端用户检测")
    @ResponseBody
    @RequestMapping("/check/result")
    public Map checkUserByInfor(@RequestParam String username,@RequestParam String password);
}
