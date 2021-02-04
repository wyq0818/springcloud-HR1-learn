package com.wyq.springcloud.service;

import com.wyq.springcloud.entity.Payment;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-04 14:32:14:32
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
