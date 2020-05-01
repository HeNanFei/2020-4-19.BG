package com.zjt.article_service.controller;

import com.zjt.article_service.service.ArticleService;
import com.zjt.common.entity.Articlea;
import com.zjt.common.handler.CommonResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "ArticleController", description = "文章管理")
@Controller
public class ArticleController {
    private final Logger logger = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "根据id删除文章")
    @RequestMapping("/article/delete/{uid}")
    public CommonResult deleteArticlea(@PathVariable @ApiParam("文章id") Integer uid){
        int i = articleService.deleteArticleaById(uid);
        if(i == 0){
            return CommonResult.failed(null,"删除失败");
        }else{
            return  CommonResult.success(null,"删除成功");
        }
    }

    @ApiOperation(value = "添加文章")
    @RequestMapping("/article/add/")
    public CommonResult addArticlea(@ApiParam("文章实体") Articlea sysPermission){
        int i = articleService.addArticlea(sysPermission);
        if(i == 0){
            return CommonResult.failed("添加失败");
        }else{
            return CommonResult.success("添加成功");
        }
    }

    @ApiOperation(value = "修改文章")
    @RequestMapping("/article/update/")
    public CommonResult updateArticlea(@ApiParam("文章实体")  Articlea sysPermission){
        int i = articleService.updateArticlea(sysPermission);
        if(i == 0){
            return CommonResult.failed("更新失败");
        }else{
            return CommonResult.success("update success");
        }
    }

    @ApiOperation(value = "列出所有文章")
    @ResponseBody
    @RequestMapping("/article/findall/")
    public CommonResult updateArticlea(@ApiParam("页码") @RequestParam  Integer pageIndex,@ApiParam("条数") @RequestParam Integer pageSize ){
        List<Articlea> allArticlea = articleService.findAllArticlea(pageIndex,pageSize);
        if(allArticlea  == null){
            return  CommonResult.failed("value is null");
        }else{
            return  CommonResult.success(allArticlea);
        }
    }

    @ApiOperation(value = "根据id查询文章")
    @ResponseBody
    @RequestMapping("/article/find/")
    public CommonResult getArticleaById(@PathVariable @RequestParam Integer id){
        Articlea sysPermissionById = articleService.findArticleaById(id);
        if(sysPermissionById == null){
            return  CommonResult.failed("value is null");
        }else{
            return  CommonResult.success(sysPermissionById);
        }
    }


}
