package com.lphu.dubbo.provider.service;

import com.lphu.dubbo.api.HelloService2;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;


/**
 * @author hupeilei
 * @date 2022/10/17
 */
@Service
public class HelloServiceImpl2 implements ApplicationContextAware, InitializingBean, HelloService2 {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20891);

        // export service
        ServiceConfig<HelloService2> serviceConfig = new ServiceConfig<>();
        serviceConfig.setApplication(lookup(ApplicationConfig.class));
        serviceConfig.setRegistry(lookup(RegistryConfig.class));
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setInterface(HelloService2.class);
        serviceConfig.setRef(this);
        serviceConfig.setVersion("1.0.0");
        serviceConfig.export();
    }

    @Override
    public String hello2(String message) {
        return "reply2 " + message;
    }

    private <T> T lookup(Class<T> clazz) {
        T t = null;
        try {
            t = applicationContext.getBean(clazz);
        } catch (NoUniqueBeanDefinitionException e) {
        } catch (NoSuchBeanDefinitionException e) {
        }
        return t;
    }
}
