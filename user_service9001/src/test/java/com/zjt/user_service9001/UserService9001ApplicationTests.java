package com.zjt.user_service9001;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

@SpringBootTest
class UserService9001ApplicationTests {

    @Test
    void contextLoads() {

        PathMatcher pathMatcher = new AntPathMatcher();
        boolean match = pathMatcher.match("/role/**", "/role/test");
        System.out.println("结果"+match);

    }

}
