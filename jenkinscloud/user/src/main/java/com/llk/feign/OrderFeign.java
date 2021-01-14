package com.llk.feign;


import com.llk.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("order")
public interface OrderFeign {

    @RequestMapping("/order/get")
    public R get();

}
