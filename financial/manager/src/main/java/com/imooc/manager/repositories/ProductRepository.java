package com.imooc.manager.repositories;

import com.imooc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 2019/08/03
 * 产品管理
 * 关于SpringData Jpa的操作可参考imooc教程
 * 《轻松愉快之玩转SpringData》
 *  地址：https://www.imooc.com/learn/821
 */
public interface ProductRepository extends JpaRepository<Product, String>,
        JpaSpecificationExecutor<Product> {
}
