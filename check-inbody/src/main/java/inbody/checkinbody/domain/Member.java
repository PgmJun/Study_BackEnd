package inbody.checkinbody.domain;

public class Member {
    private Long id;
    private String name;
    private double height;
    private double weight;
    private String gender;
    private int age;
    private String date;
    private double rmr;

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRmr(double rmr) {
        this.rmr = rmr;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getRmr() {
        return rmr;
    }
}
