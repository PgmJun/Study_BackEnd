package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetWorkClient {

    private String url;

    public NetWorkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url){
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call: " + url + "message: " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }

    //스프링컨테이너 생성시 의존관계 주입이 끝나면 호출
    @PostConstruct
    public void init(){
        System.out.println("NetWorkClient.init");
        connect();
        call("초기화 연결 메세지");

    }

    //빈이 종료시 호출
    @PreDestroy
    public void close(){
        System.out.println("NetWorkClient.close");
        disconnect();
    }
}
