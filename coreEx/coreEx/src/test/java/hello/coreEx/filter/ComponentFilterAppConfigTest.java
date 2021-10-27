package hello.coreEx.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.*;
import org.yaml.snakeyaml.introspector.BeanAccess;

public class ComponentFilterAppConfigTest {

    @Test
    void filterSacn(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        beanA beanA = ac.getBean("beanA", beanA.class);

        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean(beanB.class));
    }

    @Configuration
    @ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class))
    static class ComponentFilterAppConfig{
    }
}
