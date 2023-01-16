package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String gotoPage(HttpServletRequest request){
        request.setAttribute("msg","success");
        request.setAttribute("code",200);
        return "forward:success";
    }

    @GetMapping("/success")
    @ResponseBody
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") Integer code,
                       HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        Object msg1 = request.getAttribute("msg");
        map.put("annotationMsg",msg);
        map.put("annotationCode",code);
        map.put("requestMsg",msg1);
        return map;
    }

}
