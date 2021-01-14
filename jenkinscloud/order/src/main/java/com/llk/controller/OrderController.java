package com.llk.controller;

import com.llk.common.utils.R;
import com.llk.domain.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/get")
    public R get(){
        Order order = new Order();
        order.setOrderId(new Random(100).nextInt());
        order.setTotal(new Random(100).nextDouble());
        return R.ok("order",order);
    }
}
