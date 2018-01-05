package com.dubbo.main;

import com.dubbo.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author lizhiming  2017/8/24 14:19
 * 消费者
 */
public class ConsumerStart {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-consumer.xml"});
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取bean
        try {
            demoService.sayHello(System.currentTimeMillis() + "");
//            System.out.println("=====================================");
//            demoService.sayHello("exception");


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
