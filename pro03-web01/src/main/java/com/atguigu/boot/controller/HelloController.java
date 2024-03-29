package com.atguigu.boot.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello,BangDi";
    }

    @RequestMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,
                                      @RequestParam("age") String age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam Map<String, String> params,
                                      @CookieValue(value = "Idea-27e8f60f",required = false) String idea,
                                      @CookieValue(value = "Idea-27e8f60f",required = false) Cookie cookie) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", name);
        // 获取所有的PathVariable
        map.put("pv", pv);
        map.put("userAgent", userAgent);
        // 所有的RequestHeader
        map.put("header", header);
        map.put("age", age);
        map.put("inters", inters);
        // 所有的params
        map.put("paramms", params);
        map.put("idea",idea);
        // cookie的所有信息
        map.put("cookie",cookie);
        return map;
    }

    @RequestMapping("/save")
    public Map<String,Object>  postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }

    // cars/sell;low=34;brand=byd,audi,yd
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand")List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

    // /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId")Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId")Integer empAge){
        Map<String,Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empage",empAge);
        return map;
    }


}
