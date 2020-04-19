package com.zjt.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import sun.security.provider.ConfigFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "security.ignoreurl")
public class IgnoreUrlConfig {
   /* @Value("${security.ignoreurl}")
    private String ignore;*/


    List<String> ignoreUrls = new ArrayList<>();

    public List<String> getIgnoreUrls() {
        //String[] split = ignore.split(",");

        //ignoreUrls.addAll(Arrays.asList(split));

        return ignoreUrls;
    }

    public void setIgnoreUrls(List<String> ignoreUrls) {
        this.ignoreUrls = ignoreUrls;
    }

}
