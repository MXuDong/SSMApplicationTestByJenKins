package model;

//出账收账导致的产品数量变动
public class ObillOUPCType {
    private Integer id;

    private Integer billId;

    private Integer operationUserProductCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Integer getOperationUserProductCount() {
        return operationUserProductCount;
    }

    public void setOperationUserProductCount(Integer operationUserProductCount) {
        this.operationUserProductCount = operationUserProductCount;
    }
}