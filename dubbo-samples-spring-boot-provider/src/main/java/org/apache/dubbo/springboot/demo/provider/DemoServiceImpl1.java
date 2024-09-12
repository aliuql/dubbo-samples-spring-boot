package org.apache.dubbo.springboot.demo.provider;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.springboot.demo.DemoService;

@DubboService(
        version = "1.0",
        group = "test1",
        timeout = 10000,
        methods = {
                @Method(name = "sayHello", timeout = 20000)
        })
public class DemoServiceImpl1 implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

}
