package model;

//操作价格变化日志
public class OUPPType {
    private Integer operationId;

    private Integer userId;

    private Integer productId;

    private Integer operationType;

    private Double changePrice;

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public Double getChangePrice() {
        return changePrice;
    }

    public void setChangePrice(Double changePrice) {
        this.changePrice = changePrice;
    }
}