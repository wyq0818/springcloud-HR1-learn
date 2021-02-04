package com.wyq.springcloud.dao;

import com.wyq.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-04 14:17:14:17
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
