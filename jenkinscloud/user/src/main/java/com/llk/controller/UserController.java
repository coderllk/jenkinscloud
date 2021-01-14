package com.llk.controller;


import com.llk.common.utils.R;
import com.llk.domain.User;
import com.llk.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    OrderFeign orderFeign;

    @RequestMapping("/get")
    public R get(){
        User user = new User();
        user.setId("11");
        user.setName("name");

        R r = orderFeign.get();

        Map<String, Object> res = r.getRes();

        Map<String, Object> result = new HashMap<>();
        result.put("user",user);
        result.put("order",res);
        return R.ok("userorder",result);
    }

}
