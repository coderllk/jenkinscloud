package com.llk.controller;

import com.llk.common.utils.R;
import com.llk.domain.Order;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/get")
    public R get(){

        Order order = new Order();
        order.setOrderId(new Random(100).nextInt());
        order.setTotal(new Random(100).nextDouble());
        return R.ok("order"+port,order);
    }
}
