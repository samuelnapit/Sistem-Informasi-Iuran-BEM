package com.example.service;

import com.example.model.*;

import java.util.*;

public interface PaymentService {

    List<Payment> listPayment();

    Payment saveOrUpdatePay(Payment payment);

    Payment getId(Integer id);
//
//    void deletePayment(Integer id);
}
