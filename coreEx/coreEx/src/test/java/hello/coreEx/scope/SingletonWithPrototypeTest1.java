package hello.coreEx.scope;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);
        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        ClientBean clientBean2 = ac.getBean(ClientBean.class);

        int count1 = clientBean1.logic();
        int count2 = clientBean2.logic();
        System.out.println("count1 = " + count1);
        System.out.println("count2 = " + count2);

        Assertions.assertNotEquals(count1, count2);

        ac.close();

    }

    @Scope("singleton")
    static class ClientBean {
        private final PrototypeBean prototypeBean;

        @Autowired
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic(){
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }

    }


    @Scope("prototype")
    static class PrototypeBean{
        int count = 0;

        public void addCount(){
            count++;
        }

        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void close(){
            System.out.println("PrototypeBean.close");
        }
    }
}
