package com.atguigu.feign;

import com.atguigu.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignClient {

    @GetMapping("/payment/{id}")
    public CommonResult findPayment(@PathVariable("id") Long id);

    @GetMapping("/payment/serverPort")
    public String getServerPort();
}
