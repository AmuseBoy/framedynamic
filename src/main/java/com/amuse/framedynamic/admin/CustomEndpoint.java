package com.amuse.framedynamic.admin;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

/**
 * @ClassName CustomEndpoint
 * @Description TODO
 * @Author 刘培振
 * @Date 2022-12-05 13:44
 * @Version 1.0
 */
@Component
@Endpoint(id = "my")
public class CustomEndpoint {

    @ReadOperation
    public String endpointCustomRead(String content) {
        return "请求的内容: " + content;
    }

    @WriteOperation
    public String endpointCustomWrite(String content) {
        return "写的内容: " + content;
    }

    @DeleteOperation
    public String endpointCustomDelete(String content) {
        return "删除的内容: " + content;
    }
}
