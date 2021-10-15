package inbody.checkinbody.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Diary {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY: 쿼리에 값을 넣으면 DB가 자동으로 값을 채워주는 것
    private long num;   //의미없는 숫자

    private String id;  //유저 ID
    private String text;    //일지
    private String date;    //기록일
    private double cardio;  //유산소
    private double weight;  //몸무게
    private String target;  //운동부위

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public double getCardio() {
        return cardio;
    }

    public void setCardio(double cardio) {
        this.cardio = cardio;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
