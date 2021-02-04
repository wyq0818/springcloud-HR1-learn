package com.wyq.springcloud.service.impl;

import com.wyq.springcloud.dao.PaymentDao;
import com.wyq.springcloud.entity.Payment;
import com.wyq.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/*
 * @Author:wuyongqiang
 * @Date:2021-01-04 14:33:14:33
 */
@Service
public class PaymentServiceImpl implements PaymentService, Serializable {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
