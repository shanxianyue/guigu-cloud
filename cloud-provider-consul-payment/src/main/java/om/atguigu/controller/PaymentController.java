package om.atguigu.controller;

import com.atguigu.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/consul/payment")
    public CommonResult<Object> consul() {
        return new CommonResult<>(200, "查询成功, server_port: " + serverPort + ", randomId: " + UUID.randomUUID());
    }
}
