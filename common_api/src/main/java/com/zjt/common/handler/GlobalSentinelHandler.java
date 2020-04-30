package com.zjt.common.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Controller
public class GlobalSentinelHandler {

    @ResponseBody
    public static Map checkUserByInfor2(@RequestParam String username, @RequestParam String password, BlockException exception )throws IOException {

        Map<String,String> map= new HashMap<>();
        map.put("infor","the server is busy please try again after the voice bing");
        return map;
    }

}
