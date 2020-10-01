package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult<Object> create(Payment payment){
        int result = paymentService.save(payment);
        log.info("插入结果:{}", result);
        if (result > 0){
            return new CommonResult<>(200, "插入成功", result);
        }else{
            return new CommonResult<>(406, "插入失败");
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Object> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.findById(id);
        if (payment != null){
            return new CommonResult<>(200, "查询成功, server_port: " + serverPort, payment);
        }else{
            return new CommonResult<>(404, "没有该信息");
        }
    }

    @GetMapping("/payment/lb")
    public String getServerPort(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort + "";
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Object> get(@PathVariable("id") Long id){
        Payment payment = paymentService.findById(id);
        if (payment != null){
            return new CommonResult<>(200, "查询成功, server_port: " + serverPort, payment);
        }else{
            return new CommonResult<>(404, "没有该信息");
        }
    }
}
