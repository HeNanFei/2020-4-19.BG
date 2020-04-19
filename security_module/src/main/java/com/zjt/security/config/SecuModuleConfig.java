package com.zjt.security.config;

import com.zjt.security.components.*;
import com.zjt.security.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;
import java.util.Map;

public class SecuModuleConfig extends WebSecurityConfigurerAdapter {

    public final Logger logger = LoggerFactory.getLogger(SecuModuleConfig.class);
    @Autowired(required = false)
    private DynamicSecurityService dynamicSecurityService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =http.authorizeRequests();
        List<String> ignoreUrls = dynamicSecurityFilter().getIgnoreUrlsConfig().getIgnoreUrls();
        ignoreUrls.stream().forEach(n -> {
            logger.info("securityModule 放行啊》》》"+n);
            registry.antMatchers(n).permitAll();});

        registry.antMatchers(HttpMethod.OPTIONS).permitAll();

        registry.and().
                authorizeRequests().
                /* accessDecisionManager(dynamicAccessDecisionManager()).*/
                anyRequest().
                authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(dynamicSecurityMetadataSource());
                        o.setAccessDecisionManager(dynamicAccessDecisionManager());
                        return o;
                    }
                })
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                // 自定义权限拒绝处理类
                .and()
                .exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler())
                .authenticationEntryPoint(restAuthenticationEntryPoint())
                // 自定义权限拦截器JWT过滤器
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //有动态权限配置时添加动态权限校验过滤器
        if(dynamicSecurityService!=null){
            logger.info("动态过滤器生效");
            registry.and().addFilterBefore(dynamicSecurityFilter(), FilterSecurityInterceptor.class);
            logger.info("动态过滤器DynamicSecurityInterceptor放行url"+dynamicSecurityFilter().getIgnoreUrlsConfig().getIgnoreUrls());
        }



    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }
    @Bean
    public IgnoreUrlConfig ignoreUrlConfig(){return new IgnoreUrlConfig();}
    @Bean
    public RestfulAccessDeniedHandler restfulAccessDeniedHandler(){return new RestfulAccessDeniedHandler();}

    @Bean
    public RestAuthenticationEntryPoint restAuthenticationEntryPoint(){return new RestAuthenticationEntryPoint();}

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){return new JwtAuthenticationTokenFilter();}
    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicSecurityFilter dynamicSecurityFilter(){return new DynamicSecurityFilter();}
    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicSecurityMetadataSource dynamicSecurityMetadataSource(){return new DynamicSecurityMetadataSource();}
    @ConditionalOnBean(name = "dynamicSecurityService")
    @Bean
    public DynamicAccessDecisionManager dynamicAccessDecisionManager() {
        return new DynamicAccessDecisionManager();
    }
    @Bean
    public JwtTokenUtil jwtTokenUtil(){return new JwtTokenUtil();}


}
