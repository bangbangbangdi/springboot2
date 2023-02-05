package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.exception.UserTooManyException;
import com.atguigu.admin.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    /**
     * 不带请求参数或者参数不对时 httpStatus为400：Bad Request 一般都是浏览器参数没有传递正确
     * @param a
     * @return
     */
    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a){
        int i = 1/0;
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id")Long id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes ra){

        userService.removeById(id);
        // 此处的addAttribute操作 = path?pn=pn
        ra.addAttribute("pn",pn);

        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        /*
        List<User> users = Arrays.asList(
                new User("zhangsan", "111"),
                new User("lisi", "222"),
                new User("wangwu", "333"),
                new User("zhaoliu", "444"),
                new User("xixi", "555"));
        model.addAttribute("users",users);
        */

        //if (users.size() > 3){
        //    throw new UserTooManyException();
        //}

        // 分页查询数据
        Page<User> userPage = new Page<>(pn,2);
        // 分页查询的结果
        Page<User> page = userService.page(userPage, null);

        List<User> list = userService.list();
        model.addAttribute("page",page);

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

}
