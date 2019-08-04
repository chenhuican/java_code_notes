package com.imooc.manager.service;

import com.imooc.entity.Product;
import com.imooc.entity.enums.ProductStatus;
import com.imooc.manager.error.ErrorEnum;
import com.imooc.manager.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 产品服务类
 */

@Service
public class ProductService {

    private  static Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        log.debug("创建产品，参数:{}", product);
        //数据校验
        checkProduct(product);

        // 设置默认值
        setDefault(product);

        Product result = productRepository.save(product);

        log.debug("创建产品，结果：{}", result);
        return result;
    }

    /**
     * 设置默认值
     * 创建时间， 更新时间
     * 投资步长，锁定期，状态
     * @param product
     */
    private void setDefault(Product product) {
        if(product.getCreateAt() == null) {
            product.setCreateAt(new Date());

        }
        if (product.getUpDateAt() == null) {
            product.setUpDateAt(new Date());
        }
        if (product.getUpDateAt() == null) {
            product.setStepAmount(BigDecimal.ZERO);

        }
        if(product.getLockTerm() == null) {
            product.setLockTerm(0);
        }
        if(product.getStatus() == null) {
            product.setStatus(ProductStatus.AUDITING.name());
        }


    }

    /**
     * 产品数据校验
     * 1. 非空数据
     * 2. 收益率要0-30
     * 3. 投资布长需为整数
     * @param product
     */
    private void checkProduct(Product product) {
        // 统一异常处理， 使用自定义的异常
        Assert.notNull(product.getId(), ErrorEnum.ID_NOT_NULL.getCode());

        //其他非空
        Assert.isTrue(BigDecimal.ZERO.compareTo(product.getRewardRate()) <0
                && BigDecimal.valueOf(30).compareTo(product.getRewardRate()) >=0,
                "收益范围错误");

        Assert.isTrue(BigDecimal.valueOf(product.getStepAmount().longValue()).compareTo(product.getStepAmount())==0,
                "投资步长需为整数");
    }

    /**
     * 查询单个产品
     * @param id
     * @return 返回对应的产品或者null
     */
    public Product findOne(String id) {
        Assert.notNull(id, "需要产品编号参数");
        log.debug("查询单个产品，id={}", id);

        Product product = productRepository.findById(id).orElse(null);

        log.debug("查询单个产品，结果={}", product);
        return  product;
    }

    /**
     * 分页查询产品
     * @param idList
     * @param minRewardRate
     * @param maxRewardRate
     * @param statusList
     * @param pageable
     * @return
     */
    public Page<Product> query(List<String> idList, BigDecimal minRewardRate,
                               BigDecimal maxRewardRate, List<String> statusList,
                               Pageable pageable) {

        log.info("查询产品，idList={}, minRewardRate={}", idList, minRewardRate);

        Specification<Product> specification = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //复合查询
                Expression<String> idCol = root.get("id");
                Expression<BigDecimal> rewardRateCol = root.get("rewardRate");
                Expression<String> statusCol = root.get("status");

                List<Predicate> predicates = new ArrayList<>();

                if(idList !=null && idList.size() >0 ) {
                    predicates.add(idCol.in(idList));
                }
                if(minRewardRate != null && BigDecimal.ZERO.compareTo(minRewardRate)<0) {
                    predicates.add(cb.ge(rewardRateCol, minRewardRate));
                }
                if(maxRewardRate != null && BigDecimal.ZERO.compareTo(maxRewardRate) <0) {
                    predicates.add(cb.le(rewardRateCol, maxRewardRate));
                }
                if(statusList !=null && statusList.size() >0) {
                    predicates.add(statusCol.in(statusList));
                }

                query.where(predicates.toArray(new Predicate[0]));

                return null;
            }
        };

        Page<Product> page = productRepository.findAll(specification, pageable);
        log.info("查询产品结果，结果={}", page);

        return page;
    }


}
