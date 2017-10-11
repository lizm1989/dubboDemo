package com.dubbo.service;

import com.dubbo.api.DemoService;
import com.dubbo.error.ErrorCode;
import com.dubbo.error.GaosiAssert;
import com.dubbo.error.GaosiException;
import com.google.common.base.Preconditions;


/**
 * @author lizhiming  2017/8/24 14:08
 * 实现类
 */

public class DemoServiceImpl implements DemoService {


    public void sayHello(String msg) {
        System.out.println("DemoServiceImpl,msg=" + msg);
//        if ("exception".equals(msg)) {
//            System.out.println("DemoServiceImpl 错误信息");
//            throw new GaosiException("aa");
//        }

        Preconditions.checkArgument(false);
        //  GaosiAssert.notNull(null, ErrorCode.ACF_30001, "is.null");
    }
}
