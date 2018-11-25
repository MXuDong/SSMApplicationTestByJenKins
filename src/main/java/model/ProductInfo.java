package model;

public class ProductInfo {
    private Integer productId;

    private String productName;

    private Integer productPic;

    private Double productPrice;

    private Integer productCount;

    private Integer productMaxCount;

    private Integer productMinCount;

    private String productDesc;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getProductPic() {
        return productPic;
    }

    public void setProductPic(Integer productPic) {
        this.productPic = productPic;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getProductMaxCount() {
        return productMaxCount;
    }

    public void setProductMaxCount(Integer productMaxCount) {
        this.productMaxCount = productMaxCount;
    }

    public Integer getProductMinCount() {
        return productMinCount;
    }

    public void setProductMinCount(Integer productMinCount) {
        this.productMinCount = productMinCount;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }
}