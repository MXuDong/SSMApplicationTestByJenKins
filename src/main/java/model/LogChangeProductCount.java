package model;

public class LogChangeProductCount {
    private Integer lcpcId;

    private Integer logId;

    private Integer productId;

    private Integer productOldCount;

    private Double productOldPrice;

    private Integer productNewCount;

    public Integer getLcpcId() {
        return lcpcId;
    }

    public void setLcpcId(Integer lcpcId) {
        this.lcpcId = lcpcId;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductOldCount() {
        return productOldCount;
    }

    public void setProductOldCount(Integer productOldCount) {
        this.productOldCount = productOldCount;
    }

    public Double getProductOldPrice() {
        return productOldPrice;
    }

    public void setProductOldPrice(Double productOldPrice) {
        this.productOldPrice = productOldPrice;
    }

    public Integer getProductNewCount() {
        return productNewCount;
    }

    public void setProductNewCount(Integer productNewCount) {
        this.productNewCount = productNewCount;
    }
}