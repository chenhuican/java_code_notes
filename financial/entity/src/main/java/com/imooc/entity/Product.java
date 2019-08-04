package com.imooc.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Product {

    @Id
    private String id;
    private String name;

    private  String status;

    private BigDecimal thresholdAmount;
    private BigDecimal stepAmount;
    // 锁定期
    private  Integer lockTerm;
    private BigDecimal rewardRate;

    private String memo;
    private Date createAt;
    private Date upDateAt;

    private String createUser;
    private String updateUser;

    public Product(){}

    public Product(String id, String name, String status,
                   BigDecimal thresholdAmount, BigDecimal stepAmount, Integer lockTerm, BigDecimal rewardRate, String memo, Date createAt, Date upDateAt, String createUser, String updateUser) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.thresholdAmount = thresholdAmount;
        this.stepAmount = stepAmount;
        this.lockTerm = lockTerm;
        this.rewardRate = rewardRate;
        this.memo = memo;
        this.createAt = createAt;
        this.upDateAt = upDateAt;
        this.createUser = createUser;
        this.updateUser = updateUser;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getThresholdAmount() {
        return thresholdAmount;
    }

    public void setThresholdAmount(BigDecimal thresholdAmount) {
        this.thresholdAmount = thresholdAmount;
    }

    public BigDecimal getStepAmount() {
        return stepAmount;
    }

    public void setStepAmount(BigDecimal stepAmount) {
        this.stepAmount = stepAmount;
    }

    public Integer getLockTerm() {
        return lockTerm;
    }

    public void setLockTerm(Integer lockTerm) {
        this.lockTerm = lockTerm;
    }

    public BigDecimal getRewardRate() {
        return rewardRate;
    }

    public void setRewardRate(BigDecimal rewardRate) {
        this.rewardRate = rewardRate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpDateAt() {
        return upDateAt;
    }

    public void setUpDateAt(Date upDateAt) {
        this.upDateAt = upDateAt;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}

