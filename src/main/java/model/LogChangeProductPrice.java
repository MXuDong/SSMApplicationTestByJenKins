package model;

public class LogChangeProductPrice {
    private Integer lcppId;

    private Integer logId;

    private Integer productId;

    private Integer productOldCount;

    private Integer productOldPrice;

    private Integer productNewPrice;

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

    public Integer getProductOldPrice() {
        return productOldPrice;
    }

    public void setProductOldPrice(Integer productOldPrice) {
        this.productOldPrice = productOldPrice;
    }

    public Integer getProductNewPrice() {
        return productNewPrice;
    }

    public void setProductNewPrice(Integer productNewPrice) {
        this.productNewPrice = productNewPrice;
    }
}