package hello.core.singleton;

import org.junit.jupiter.api.Test;

public class SingleTonService {

    //static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.
    private static final SingleTonService instance = new SingleTonService();

    //이 객체 인스턴스가 필요하면 오직 getInstance() 메서드를 통해서만 조회할 수 있다.
    //이 메서드를 통해 호출하면 항상 같은 인스턴스를 반환한다
    public static SingleTonService getInstance(){
        return instance;
    }

    //딱 1개의 객체 인스턴스만 존재해야 하므로, 생성자를 private로 막아서 혹시라도 외부에서 new 키워드로 인스턴스가 생성되는 것을 막는다.
    private SingleTonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
