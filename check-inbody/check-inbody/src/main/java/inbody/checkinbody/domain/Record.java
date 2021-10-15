package inbody.checkinbody.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Record {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY: 쿼리에 값을 넣으면 DB가 자동으로 값을 채워주는 것
    private long num;   //의미없는 숫자

    private String id;  //유저 ID
    private String name;    //유저 이름
    private String date;    //기록 날짜
    private String gender;  //성별
    private double rmr; //기초대사량 Resting Metabolic Rate(RMR)
    private double height;  //키
    private double weight;  //몸무게
    private int age;    //나이

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getRmr() {
        return rmr;
    }

    public void setRmr(double rmr) {
        this.rmr = rmr;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }
}
