package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok h = new HelloLombok();
        h.setName("lombok");
        System.out.println(h.getName());

        System.out.println("h = " + h);
    }
}
