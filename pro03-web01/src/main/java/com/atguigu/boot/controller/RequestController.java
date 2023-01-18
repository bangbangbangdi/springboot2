package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String gotoPage(HttpServletRequest request) {
        request.setAttribute("msg", "success");
        request.setAttribute("code", 200);
        return "forward:success";
    }

    @GetMapping("/params")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        map.put("hello", "world777");
        model.addAttribute("world", "hello777");
        request.setAttribute("message", "HelloWorld");
        Cookie cookie = new Cookie("c1", "v1");
        response.addCookie(cookie);
        return "forward:/success";
    }

    @GetMapping("/success")
    @ResponseBody
    public Map success(@RequestAttribute(value = "msg",required = false) String msg,
                       @RequestAttribute(value = "code",required = false) Integer code,
                       HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Object msg1 = request.getAttribute("msg");
        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");

        map.put("annotationMsg", msg);
        map.put("annotationCode", code);
        map.put("requestMsg", msg1);

        map.put("hello", hello);
        map.put("world", world);
        map.put("message",message);
        return map;
    }

}
