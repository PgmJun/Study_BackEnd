package inbody.checkinbody.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class WeightControl {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY: 쿼리에 값을 넣으면 DB가 자동으로 값을 채워주는 것
    private long num;

    private String id; //유저 ID
    private String date; //기록 날짜
    private double currentWeight; //현재 몸무게
    private double goalWeight; //목표 몸무게
    private String startDate; //체중조절 시작일
    private String finishDate; //체중조절 종료일
    private long totalDate; //종료일 - 시작일
    private double wlm; //감량대사량

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(double goalWeight) {
        this.goalWeight = goalWeight;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public long getTotalDate() {
        return totalDate;
    }

    public void setTotalDate(long totalDate) {
        this.totalDate = totalDate;
    }

    public double getWlm() {
        return wlm;
    }

    public void setWlm(double wlm) {
        this.wlm = wlm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
