package com.dubbo.service;

import com.dubbo.api.DemoService;

import java.util.Map;


/**
 * @author lizhiming  2017/8/24 14:08
 */

public class DemoServiceImpl implements DemoService {


    public void sayHello(String msg) throws Exception {
        System.out.println("DemoServiceImpl,msg=" + msg);
        if ("exception".equals(msg)) {
            throw new Exception();
        }
    }
}
