package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        //basePakages : 탐색할 패키지 시작위치 지정. 이 패키지 아래를 탐색
//        basePackages = "hello.core.member",
//        //basePakageClasses : 지정한 클래스의 패키지를 탐색 위치로 지정
//        basePackageClasses = AutoAppConfig.class,
        //Configuration 어노테이션이 붙은 클래스를 제외하고 스프링빈에 등록
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
