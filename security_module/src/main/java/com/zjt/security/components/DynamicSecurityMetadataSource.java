package com.zjt.security.components;

import cn.hutool.core.util.URLUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.annotation.PostConstruct;
import java.util.*;

public class DynamicSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    public final Logger logger = LoggerFactory.getLogger(DynamicSecurityMetadataSource.class);
    private static Map<String, ConfigAttribute> configAttributeMap = null;

    @Autowired
    private DynamicSecurityService dynamicSecurityService;
    @PostConstruct
    public void loadDataSource() {
        configAttributeMap = dynamicSecurityService.loadDataSource();
    }

    public void clearDataSource() {
        configAttributeMap.clear();
        configAttributeMap = null;
    }


    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        if (configAttributeMap == null) { logger.info("权限为空 载入权限");this.loadDataSource();}
        List<ConfigAttribute> configAttributes = new ArrayList<>();
        //获取当前访问的路径
        String url = ((FilterInvocation) o).getRequestUrl();
        String path = URLUtil.getPath(url);
        PathMatcher pathMatcher = new AntPathMatcher();
        Iterator<String> iterator = configAttributeMap.keySet().iterator();
        //获取访问该路径所需资源
        while (iterator.hasNext()) {
            String pattern = iterator.next();
            logger.info("系统放行的路径"+pattern+"用户请求路径"+path);
            if (pathMatcher.match(pattern, path)) {
                logger.info("权限加入"+configAttributeMap.get(pattern));
                configAttributes.add(configAttributeMap.get(pattern));
            }/*else{
                ConfigAttribute configAttribute = new SecurityConfig("It can't be null");
                configAttributes.add(configAttribute);
            }*/
        }
        // 未设置操作请求权限，返回空集合
        logger.info("未设置操作请求权限，返回空集合");
        configAttributes.stream().forEach(n -> System.out.println(n.getAttribute().toString()));
        return configAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
