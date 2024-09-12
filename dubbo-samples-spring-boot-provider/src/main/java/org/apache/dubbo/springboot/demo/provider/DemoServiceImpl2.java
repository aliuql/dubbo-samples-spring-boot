package org.apache.dubbo.springboot.demo.provider;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.springboot.demo.DemoService;

@DubboService(
        version = "2.0",
        group = "test2",
        timeout = 10000,
        protocol = "dubbo,tri",
        methods = {
                @Method(name = "sayHello", timeout = 20000)
        })
public class DemoServiceImpl2 implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

}
