package com.dubbo.service;

import com.dubbo.api.DemoService;
import com.google.common.base.Preconditions;


/**
 * @author lizhiming  2017/8/24 14:08
 * 实现类
 */

public class DemoServiceImpl implements DemoService {


    @Override
    public void sayHello(String msg) {
        System.out.println("DemoServiceImpl,msg=" + msg);
//        if ("exception".equals(msg)) {
//            System.out.println("DemoServiceImpl 错误信息");
//        }

        Preconditions.checkArgument(false);
    }
}
