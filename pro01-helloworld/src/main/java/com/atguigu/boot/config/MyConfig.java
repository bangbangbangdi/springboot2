package com.atguigu.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

/*
 * 1.配置类里面使用的@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2.配置类本身也是组件
 * 3.ProxyBeanMethods：代理bean的方法
 *       Full(proxyBeanMethods = true)
 *       Lite(proxyBeanMethods = false)
 *       组件依赖
 * 4.@Import({User.class,DBHelper.class})
 *      给容器中自动创建出这两个类型的组件,默认组件的名字就是全类名
 * 5.@ImportResource("classpath:bean.xml")
 *      引入原生配置文件
 * */
@Import({User.class, DBHelper.class})
//声明这是一个配置类 == 配置文件
@Configuration(proxyBeanMethods = false)
//@ConditionalOnBean(name = "tom")
@ConditionalOnMissingBean(name = "tom")
@ImportResource("classpath:bean.xml")
@EnableConfigurationProperties(Car.class)
//1.开启Car配置绑定功能
//2.把这个Car这个组件自动注册到容器中 (应用场景：引入第三方Jar包时，由于没有权限直接修改.java文件，我们就可以选择这种方法实现属性绑定)
public class MyConfig {

    //给容器中添加组件，以方法名作为组件id，返回类型就是组件类型，返回的值，就是组件在容器中的实例
    //外部无论对配置类中这个组件注册方法调用多少次，获得的都是之前注册容器中的单实例对象
    @Bean
    public User user01() {
        User miemie = new User("miemie", 20);
        // user组件依赖了Pet组件
        miemie.setPet(tomcatPet());
        return miemie;
    }

    @Bean("tom22")
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }

}
