package com.amuse.framedynamic.admin;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyInfo
 * @Description TODO
 * @Author 刘培振
 * @Date 2022-12-05 13:35
 * @Version 1.0
 */
@Component
public class MyInfo implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, String> info = new HashMap<>();
        info.put("name", "小刘");
        info.put("email", "liupeizhe@baiwang.com");
        builder.withDetail("author", info);
    }
}
