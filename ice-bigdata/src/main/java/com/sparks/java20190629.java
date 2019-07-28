package com.sparks;

import java.lang.annotation.*;

/**
 * 20190629
 * java注解：
 * Java提供了一种源程序中的元素关联任何信息和任何元数据的途径和方法
 * 注解分类：
 *   一、按照运行机制分
 *   1) 源码注解
 *   2) 编译时注解
 *   3) 运行时注解
 *
 *解析注解：
 * 通过反射获取类，函数或成员上的运行时注解信息，从而实现动态控制程序运行的逻辑
 *
 */
public class java20190629 {
    public static void main(String[] args) {
        System.out.println("java20190629.main");
        System.out.println("java20190629.main");

    }

    //自定义注解的语法要求
    @Target({ElementType.METHOD,ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Documented
    public @interface Description{
        String desc();
        String author();
        int age() default 18;
    }

    @Description(desc = "I am eyeColor", author = "Mooc biy",age=19)
    public String eyeColor(){
        return "red";
    }

}
