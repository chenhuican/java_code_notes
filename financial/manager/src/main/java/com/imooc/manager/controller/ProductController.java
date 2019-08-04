package com.imooc.manager.controller;

import com.imooc.entity.Product;
import com.imooc.manager.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 产品API
 */

@RestController
@RequestMapping("/products")
public class ProductController {

    private static Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product) {
        log.info("创建产品，参数：{}", product);

        Product result = service.addProduct(product);
        log.info("创建产品，结果：{}", result);
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product findOne(@PathVariable String id) {
        log.info("查询单个产品， id={}", id);
        Product product = service.findOne(id);
        log.info("查询单个产品，结果={}", product);
        return product;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Product> query(String ids, BigDecimal minRewardRate,
                               BigDecimal maxRewardRate, String status,
                               @RequestParam(defaultValue = "0") int pageNum,
                               @RequestParam(defaultValue = "10") int pageSize) {

        List<String> idList = null, statusList = null;

        // StringUtils提供字符串判断
        if(!StringUtils.isEmpty(ids)) {
            idList = Arrays.asList(ids.split(","));
        }

        if(!StringUtils.isEmpty(status)) {
            statusList = Arrays.asList(status.split(","));
        }
        Pageable pageable = new PageRequest(pageNum, pageSize);

        Page<Product> page = service.query(idList, minRewardRate, maxRewardRate, statusList, pageable);
        return page;
    }
}
