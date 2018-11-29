package model;

public class LogChangeProductPrice {
    private Integer lcppId;

    private Integer logId;

    private Integer productId;

    private Integer productOldCount;

    private Double productOldPrice;

    private Double productNewPrice;

    public Integer getLcppId() {
        return lcppId;
    }

    public void setLcppId(Integer lcppId) {
        this.lcppId = lcppId;
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

    public Double getProductNewPrice() {
        return productNewPrice;
    }

    public void setProductNewPrice(Double productNewPrice) {
        this.productNewPrice = productNewPrice;
    }
}