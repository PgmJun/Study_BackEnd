package hello.coreEx.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

public class BeanLifeCycleTest {

    @Test
    void lifeCycle(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        ac.getBean(NetWorkClient.class);
        ac.close();

    }

    @Configuration
    static class LifeCycleConfig{

        @Bean
        public NetWorkClient netWorkClient(){
            NetWorkClient netWorkClient = new NetWorkClient();
            netWorkClient.setUrl("http://www.hello-spring.com");
            return netWorkClient;
        }
    }
}
