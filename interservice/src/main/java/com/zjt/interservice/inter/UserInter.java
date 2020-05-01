package com.zjt.interservice.inter;

import com.zjt.common.entity.SysUser2;
import com.zjt.common.handler.CommonResult;
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
    @RequestMapping("/user/delete/")
    public CommonResult deleteUser2(@PathVariable @ApiParam("用户uid") @RequestParam Integer uid);

    @ApiOperation(value = "添加用户")
    @RequestMapping("/user/add/")
    public CommonResult addUser(@ApiParam("用户实体") @RequestParam SysUser2 user);

    @ApiOperation(value = "修改用户")
    @RequestMapping("/user/update/")
    public CommonResult updateUser(@ApiParam("用户实体") @RequestParam SysUser2 user);

    @ApiOperation(value = "列出所有用户")
    @ResponseBody
    @RequestMapping("/user/findall/")
    public CommonResult findAllUser(@ApiParam("页码") @RequestParam  Integer pageIndex,@ApiParam("条数") @RequestParam  Integer pageSize);

    @ApiOperation(value = "根据id查询用户")
    @ResponseBody
    @RequestMapping("/user/find/{id}")
    public CommonResult getUserById(@PathVariable @RequestParam Integer id);

    @ApiOperation(value = "根据姓名查询用户")
    @ResponseBody
    @RequestMapping("/user/find/name/{username}")
    public CommonResult getUserByName(@PathVariable @RequestParam String username);

    @ApiOperation(value = "前端用户检测")
    @ResponseBody
    @RequestMapping("/check/result")
    public CommonResult checkUserByInfor(@RequestParam String username,@RequestParam String password);
}
