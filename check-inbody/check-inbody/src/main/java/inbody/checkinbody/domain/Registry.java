package inbody.checkinbody.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Registry {
    @Id
    private String id;  //회원가입 유저 ID

    private String pw;  //회원가입 유저 PW

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
