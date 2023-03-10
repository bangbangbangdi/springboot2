package com.atguigu.admin.controller;

import com.atguigu.admin.bean.*;
import com.atguigu.admin.service.CityService;
import com.atguigu.admin.service.FruitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    FruitService fruitService;

    /*
    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id")Long id){
        return cityService.getById(id);
    }
    */

    @Autowired
    CityService cityService;

    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city){
        cityService.saveCity(city);
        log.info(city.toString());
        return city;
    }

    @ResponseBody
    @GetMapping("/fruit")
    public Fruit getById(@RequestParam("fid") Integer fid){
        Fruit fruit = fruitService.getFruitById(fid);
        //log.info(fruit.toString());
        return fruit;
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from jobs", Long.class);
        return aLong.toString();
    }

    @GetMapping({"/", "/login"})
    public String loginPage(HttpServletRequest request) {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {

        if (StringUtils.hasLength(user.getUserName()) && "1".equals(user.getPassword())) {
            // ?????????????????????????????????
            session.setAttribute("loginUser", user);
            //????????????????????????main.html  ?????????????????????????????????
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "??????????????????");
            // ??????????????????
            return "login";
        }

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model) {

        log.info("???????????????:{}","mainPage");
        //// ?????????????????????????????????????????? ????????? ??????????????????
        //Object loginUser = session.getAttribute("loginUser");
        //if (loginUser != null) {
        //    return "main";
        //} else {
        //    model.addAttribute("msg","???????????????");
        //    return "login";
        //}
        return "main";
    }

}
