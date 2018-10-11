package com.example.restfulservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author corn
 * @version 1.0.0
 */

@Controller
public class LoginController {

    @PostMapping(value = "/user/signin")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session) {
        if(!StringUtils.isEmpty(username) && "1".equals(password)) {
            // 记录登录情况，防止直接通过get登录
            session.setAttribute("loginUser", username);
            // 登录成功,防止表单重复提交使用重定向
            return "redirect:/main.html";
        } else {
            // 登录失败
            map.put("msg", "用户名密码错误");
            return "signin";
        }
    }
}
