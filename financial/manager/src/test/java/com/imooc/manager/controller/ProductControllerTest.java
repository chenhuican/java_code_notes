package com.imooc.manager.controller;

import com.imooc.entity.Product;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能测试
 * SpringBootTest.WebEnvironment.RANDOM_PORT 随机生成一个启动端口
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    private static RestTemplate rest = new RestTemplate();

    //获取随机生成的端口路径
    @Value("http://localhost:${local.server.port}/manager")
    private String baseUrl;

    // 正常产品数据
    private static List<Product> normals = new ArrayList<>();

    // 初始化，只执行一次，利用注解BeforeClass
    @BeforeClass
    public static void init(){

    }

    @Test
    public void Create() {

    }
}
