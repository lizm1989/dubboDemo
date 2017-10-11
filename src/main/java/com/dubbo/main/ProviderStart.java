package com.dubbo.main;

import com.dubbo.service.DemoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author Administrator
 */
public class ProviderStart {
    private static final Logger logger = LoggerFactory.getLogger(ProviderStart.class);

    private static final String CONFIG_FILE_SPRING = "dubbo-provider.xml";


    public static void main(String[] args) throws InterruptedException {
        ProviderStart provider = new ProviderStart();
        provider.start();

        com.alibaba.dubbo.container.Main.main(args);//通过dubbo的container加载
    }

    private void start() {
        ApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_FILE_SPRING);
        String[] names = context.getBeanDefinitionNames();
        System.out.println("---------------------------Beans:");
        for (String string : names)
            System.out.println(string + ",");
        System.out.println("--------------------------");
    }

}
