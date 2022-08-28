package com.xu.ggkt.vod.controller;

import com.xu.ggkt.result.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@Api(tags = "用户管理接口")
@CrossOrigin //允许跨域访问
@RestController
@RequestMapping("/admin/vod/user")
public class UserController {


    /**
     * 用户登录
     * @return
     */
    @PostMapping("/login")
    public Result login(){
        //{"code":20000,"data":{"token":"admin-token"}}
        Map<String, Object> map = new HashMap<>();
        map.put("token","admin-token");
        return Result.ok(map);
    }

    /**
     * 用户登录
     * @return
     */
    @GetMapping("/info")
    public Result info(){
        //{"code":20000,
        // "data":{
        // "roles":["admin"],
        // "introduction":"I am a super administrator",
        // "avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
        // "name":"Super Admin"
        // }}
        Map<String, Object> map = new HashMap<>();
        map.put("roles","admin");
        map.put("introduction","I am a super administrator");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("name","Super Admin");
        return Result.ok(map);
    }

}
