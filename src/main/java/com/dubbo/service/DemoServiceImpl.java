package com.dubbo.service;

import com.dubbo.api.DemoService;


/**
 * @author lizhiming  2017/8/24 14:08
 * 实现类
 */

public class DemoServiceImpl implements DemoService {


    public void sayHello(String msg) throws Exception {
        System.out.println("DemoServiceImpl,msg=" + msg);
        if ("exception".equals(msg)) {
            throw new Exception();
        }
    }
}
