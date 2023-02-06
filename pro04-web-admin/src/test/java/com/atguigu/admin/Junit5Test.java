package com.atguigu.admin;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/*
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@ExtendWith(SpringExtension.class)    // 以下的测试内容使用Spring的测试驱动
*/
//@SpringBootTest
@DisplayName("junit5功能测试类")
public class Junit5Test {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 测试前置条件
     */
    @DisplayName("testAssumptions")
    @Test
    void testAssumptions(){
        Assumptions.assumeTrue(false,"结果不是true");
        System.out.println("1111");
    }

    /**
     * 断言：前面断言失败，后边的代码都不会执行
     */
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions() {
        int cal = cal(2, 3);
        // 相等
        assertEquals(5,cal,"业务逻辑计算失败");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1,obj2,"两个对象不一样");
    }

    int cal(int i, int j) {
        return i + j;
    }

    @Test
    @DisplayName("array assertion")
    void array(){
        assertArrayEquals(new int[]{1,2},new int[]{1,2},"数组内容不相等");
    }

    @Test
    @DisplayName("assertAll")
    void all(){
        /**
         * 所有断言全部需要成功
         */
        assertAll("test",
                ()-> assertTrue(true && true,"结果不为true"),
                ()-> assertEquals(2,1,"结果不是1"));
    }

    @DisplayName("Exception assert")
    @Test
    void testException(){
        // 断定业务逻辑一定出现异常
        assertThrows(ArithmeticException.class,()->{int i = 10/2;},"no exception was thrown");
    }

    @DisplayName("quickly fail")
    @Test
    void testFail(){
        if (1 == 4){
            fail("测试失败");
        }
    }


    @DisplayName("TestDisplayNameAnnotation")
    @Test
    void testDisplayName() {
        System.out.println(1);
        System.out.println(jdbcTemplate);
    }

    @Disabled
    @DisplayName("TestDisplayNameAnnotation2")
    @Test
    void testDisplayName2() {
        System.out.println(2);
    }

    @RepeatedTest(5)
    @Test
    void test3() {
        System.out.println("miemie");
    }

    /**
     * 规定方法超时时间，超出时间测试出异常
     *
     * @throws InterruptedException
     */
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(700);
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("Test Beginning...");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("Test Over");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("All Test Beginning");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("All Test Over");
    }

}
