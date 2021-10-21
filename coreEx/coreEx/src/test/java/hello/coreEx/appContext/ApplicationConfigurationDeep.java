package hello.coreEx.appContext;

import hello.coreEx.AutoAppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationConfigurationDeep {

    @Test
    void ConfigurationDepp(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        AutoAppConfig bean = ac.getBean(AutoAppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());
    }
}
