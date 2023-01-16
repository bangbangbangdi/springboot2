package com.atguigu.boot.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    @RequestMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") String age,
                                     @RequestParam("inters")List<String> inters,
                                     @RequestParam Map<String,String> params,
                                     @CookieValue("Idea-27e8f60f") String idea,
                                     @CookieValue("Idea-27e8f60f") Cookie cookie){
        Map<String,Object> map = new HashMap<>();
        //map.put("id",id);
        //map.put("username",name);
        //map.put("pv",pv);
        //map.put("userAgent",userAgent);
        //map.put("header",header);
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        map.put("idea",idea);
        map.put("cookie",cookie);
        return map;
    }

    @RequestMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,String> map = new HashMap<>();
        map.put("content",content);
        return map;
    }

    // /cars/sell;low=42;brand=audi,by
    @GetMapping("/cars/sell")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        return map;
    }

}
