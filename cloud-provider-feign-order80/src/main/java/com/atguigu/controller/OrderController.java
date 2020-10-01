package com.atguigu.controller;

import com.atguigu.feign.PaymentFeignClient;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentFeignClient paymentFeignClient;

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> findPayment(@PathVariable("id") Long id){
        return paymentFeignClient.findPayment(id);
    }

    @GetMapping("/consumer/payment/serverPort")
    public String findPaymentServerPort(){
        return paymentFeignClient.getServerPort();
    }
}
