package inbody.checkinbody.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class WeightControl {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY: 쿼리에 값을 넣으면 DB가 자동으로 값을 채워주는 것
    private long num;

    private String date;
    private double currentWeight;
    private double goalWeight;
    private String startDate;
    private String finishDate;
    private long totalDate;
    private double bmr; //기초대사량
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

    public double getBmr() {
        return bmr;
    }

    public void setBmr(double bmr) {
        this.bmr = bmr;
    }

    public double getWlm() {
        return wlm;
    }

    public void setWlm(double wlm) {
        this.wlm = wlm;
    }
}
