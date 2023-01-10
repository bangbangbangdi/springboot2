package com.atguigu.boot;


import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/*
 * 主程序类
 * @SpringBootApplication:这是一个springboot应用
 * */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2.查看你IOC容器里面的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).forEach(System.out::println);

        /*
        //3.从容器中获取组件
        Pet tom01 = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);
        System.out.println(tom01 == tom02);


        //bean = com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$8ae3bb07@26844abb
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println("bean = " + bean);

        //如果@Configuration（proxyBeanMethods = true）代理对象调用方法，SpringBoot总会检查这个组件中是否在容器中，保持组件单实例
        User user01 = bean.user01();
        User user02 = bean.user01();
        System.out.println("equals" + (user01 == user02));

        User miemie = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);
        System.out.println("用户的宠物：" + (user01.getPet() == tom));

        System.out.println("========================");
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        Arrays.asList(beanNamesForType).forEach(System.out::println);

        DBHelper bean1 = run.getBean(DBHelper.class);
        System.out.println("bean1 = " + bean1);
        */
        boolean tom = run.containsBean("tom22");
        System.out.println("tom22 " + tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("user01 " + user01);

        boolean haha = run.containsBean("haha");
        System.out.println("haha " + haha);

        boolean hehe = run.containsBean("hehe");
        System.out.println("hehe " + hehe);
    }

}
