package com.imooc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 2019/07/14
 * Controller获取参数
 * @PathVariable  获取Url中的数据
 * @RequestParam 获取请求参数的值 获取 如：http://localhost/hi?id=12
 * @GetMapping 组合注解
 */

@RestController
public class HelloController {

    @RequestMapping(value = "/hi/{id}", method = RequestMethod.GET)
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "id: " + id;
    }
}
