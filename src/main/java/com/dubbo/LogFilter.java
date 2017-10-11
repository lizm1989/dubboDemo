package com.dubbo;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;

/**
 * @author lizhiming  2017/10/11 14:04
 * Constants.PROVIDER 生成者有效
 * Constants.CONSUMER 消费者有效
 * <p>
 * 拦截器，可以做日志拦截、权限等
 */
@Activate(group = {Constants.PROVIDER, Constants.CONSUMER}, order = -9000)
public class LogFilter implements Filter {
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        //System.out.println("start============filter");

        Result result = invoker.invoke(invocation);
        if (result.hasException()) {
            System.out.println("异常异常异常");
        }
        //System.out.println("LogFilter result :" + new Gson().toJson(result == null ? "" : result));
        //System.out.println("end============filter");
        return result;
    }
}
