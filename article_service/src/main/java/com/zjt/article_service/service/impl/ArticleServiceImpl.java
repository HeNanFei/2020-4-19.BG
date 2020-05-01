package com.zjt.article_service.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjt.article_service.service.ArticleService;
import com.zjt.common.entity.Articlea;
import com.zjt.common.entity.ArticleaExample;
import com.zjt.common.inter.ArticleaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleaMapper articleaMapper;
    @Override
    public Articlea findArticleaById(Integer id) {
        return articleaMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteArticleaById(Integer id) { return articleaMapper.deleteByPrimaryKey( id); }

    @Override
    public int addArticlea(Articlea sysPermission) {
        return articleaMapper.insert(sysPermission);
    }

    @Override
    public List<Articlea> findAllArticlea(Integer pageIndex,Integer PageSize) {
        ArticleaExample sysPermissionExample = new ArticleaExample();
        ArticleaExample.Criteria criteria = sysPermissionExample.createCriteria();
        criteria.andArticleidIsNotNull();
        PageHelper.startPage(pageIndex,PageSize);
        List<Articlea> sysPermission2s = articleaMapper.selectByExample(sysPermissionExample);
        PageInfo<Articlea> pageInfo = new PageInfo<>(sysPermission2s);
        List<Articlea> list = pageInfo.getList();
        return list;
    }

    @Override
    public int updateArticlea(Articlea sysPermission) {
        ArticleaExample sysPermissionExample = new ArticleaExample();
        ArticleaExample.Criteria criteria = sysPermissionExample.createCriteria();
        criteria.andArticleidEqualTo(sysPermission.getArticleid());
        return articleaMapper.updateByExampleSelective(sysPermission,sysPermissionExample);
    }


    @Override
    public List<Articlea> findAllArticlea() {
        ArticleaExample sysPermissionExample = new ArticleaExample();
        ArticleaExample.Criteria criteria = sysPermissionExample.createCriteria();
        criteria.andArticleidIsNotNull();

        return articleaMapper.selectByExample(sysPermissionExample);

    }
}
