package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

//    @Test
//    void statefulServiceSingleton(){
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
//        StatefulService statefulService1 = ac.getBean(StatefulService.class);
//        StatefulService statefulService2 = ac.getBean(StatefulService.class);
//
//        //ThreadA: A사용자 10000원 주문
//        statefulService1.order("userA", 10000);
//        //ThreadA: B사용자 20000원 주문
//        statefulService2.order("userB", 20000);
//
//        //ThreadA: 사용자A 주문 금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);
//
//        assertThat(statefulService1.getPrice()).isEqualTo(20000);
//
//    }
    //싱글톤을 사용할 때의 주의점: 공유되지 않는 무상태(stateLess)로 설계해라!!!!!!!!!!
    //price가 공유되는 값이면 돈관련 큰 문제가 생긴다. 항상 공유되지 않는 값을 사용하도록 주의하자

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadA: B사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
        System.out.println("userAPrice = " + userAPrice);


    }



    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}