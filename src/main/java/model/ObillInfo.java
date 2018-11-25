package model;

import java.util.Date;

public class ObillInfo {
    private Integer obill;

    private Date obillTime;

    private Double obillMoney;

    public Integer getObill() {
        return obill;
    }

    public void setObill(Integer obill) {
        this.obill = obill;
    }

    public Date getObillTime() {
        return obillTime;
    }

    public void setObillTime(Date obillTime) {
        this.obillTime = obillTime;
    }

    public Double getObillMoney() {
        return obillMoney;
    }

    public void setObillMoney(Double obillMoney) {
        this.obillMoney = obillMoney;
    }
}