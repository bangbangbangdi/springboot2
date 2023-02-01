package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Fruit;
import com.atguigu.admin.bean.User;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    FruitService fruitService;

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
            // 把登录成功的用户存起来
            session.setAttribute("loginUser", user);
            //登录成功重定向到main.html  重定向防止表单重复提交
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            // 回到登录页面
            return "login";
        }

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model) {

        log.info("当前方法是:{}","mainPage");
        //// 正常情况下应该将这个处理放在 拦截器 过滤器中处理
        //Object loginUser = session.getAttribute("loginUser");
        //if (loginUser != null) {
        //    return "main";
        //} else {
        //    model.addAttribute("msg","请重新登录");
        //    return "login";
        //}
        return "main";
    }

}
