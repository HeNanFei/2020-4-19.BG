package com.zjt.interservice.controller;

import com.zjt.common.entity.Articlea;
import com.zjt.common.handler.CommonResult;
import com.zjt.interservice.inter.ArticleInter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {

    @Autowired
    private ArticleInter articleInter;
    @ApiOperation(value = "根据id删除文章")
    @RequestMapping("/article/delete/{uid}")
    public CommonResult deleteArticlea(@PathVariable @ApiParam("文章id") Integer uid){
        return articleInter.deleteArticlea(uid);
    }

    @ApiOperation(value = "添加文章")
    @RequestMapping("/article/add/")
    public CommonResult addArticlea(@ApiParam("文章实体") Articlea sysPermission){ return articleInter.addArticlea(sysPermission); }

    @ApiOperation(value = "修改文章")
    @RequestMapping("/article/update/")
    public CommonResult updateArticlea(@ApiParam("文章实体")  Articlea sysPermission){ return articleInter.updateArticlea(sysPermission); }

    @ApiOperation(value = "列出所有文章")
    @ResponseBody
    @RequestMapping("/article/findall/")
    public CommonResult updateArticlea(@ApiParam("页码") @RequestParam Integer pageIndex, @ApiParam("条数") @RequestParam Integer pageSize ){ return articleInter.updateArticlea(pageIndex,pageSize); }

    @ApiOperation(value = "根据id查询文章")
    @ResponseBody
    @RequestMapping("/article/find/")
    public CommonResult getArticleaById(@PathVariable @RequestParam Integer id){ return articleInter.getArticleaById(id); }

}
