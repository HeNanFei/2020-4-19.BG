package com.zjt.security.components;

import cn.hutool.core.collection.CollUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

public class DynamicAccessDecisionManager implements AccessDecisionManager {
    public final Logger logger = LoggerFactory.getLogger(DynamicAccessDecisionManager.class);
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        // 当接口未被配置资源时直接放行
        if (CollUtil.isEmpty(collection)) {
            return;
        }
        Iterator<ConfigAttribute> iterator = collection.iterator();

        while (iterator.hasNext()) {
            ConfigAttribute configAttribute = iterator.next();

            //将访问所需资源或用户拥有资源进行比对
            String needAuthority = configAttribute.getAttribute();
            logger.info("系统定义权限"+needAuthority+"用户权限"+authentication.getAuthorities());
            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                logger.info("需要验证的权限"+needAuthority+"用户权限"+grantedAuthority+"DynamicAccesssDecisionManager 权限匹配"+needAuthority.trim().equals(grantedAuthority.getAuthority()));
                if (needAuthority.trim().equals(grantedAuthority.getAuthority())) {
                    return;
                }
            }
        }
        //System.out.println("迭代器"+collection.size());
        throw new AccessDeniedException("抱歉，您没有访问权限");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
