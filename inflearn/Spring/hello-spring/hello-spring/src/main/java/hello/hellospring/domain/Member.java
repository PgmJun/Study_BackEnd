package hello.hellospring.domain;


import javax.persistence.*;

@Entity //jpa가 관리하겠다는 표식(ORM: 오브젝트와 관계형 데이터베이스 맵핑)
public class Member {

    //@Id: Primary Key 설정
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY: 쿼리에 값을 넣으면 DB가 자동으로 값을 채워주는 것
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
