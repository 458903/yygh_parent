package com.fanfanfan.yygh.hosp.controller;

import com.fanfanfan.yygh.common.result.R;
import com.fanfanfan.yygh.model.acl.User;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/admin/user")
public class UserController {
    @PostMapping(value = "/login")
    public R login(@RequestBody User user){
        return R.ok().data("token","admin-token");
    }
    @GetMapping(value = "/info")
    public R info(String token){
        return R.ok().data("roles","[admin]")
                .data("introduction","I am a super administrator")
                .data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif")
                .data("name","Super Admin");
    }
}
