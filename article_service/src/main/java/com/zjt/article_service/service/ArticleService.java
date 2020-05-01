package com.zjt.article_service.service;

import com.zjt.common.entity.Articlea;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    Articlea findArticleaById(Integer id);

    int deleteArticleaById(Integer id);

    int addArticlea(Articlea sysPermission);

    List<Articlea> findAllArticlea(Integer pageIndex,Integer pageSize);

    List<Articlea> findAllArticlea();

    int updateArticlea(Articlea sysPermission);


}
