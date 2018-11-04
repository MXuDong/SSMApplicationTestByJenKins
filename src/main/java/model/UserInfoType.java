package model;

//用户详细信息
public class UserInfoType {
    private Integer userId;

    private String userPassword;

    private Integer userPower;

    private String contactWay;

    private String userName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserPower() {
        return userPower;
    }

    public void setUserPower(Integer userPower) {
        this.userPower = userPower;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay == null ? null : contactWay.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    @Override
    public String toString() {
        return "UserInfoType{" +
                "userId=" + userId +
                ", userPassword='" + userPassword + '\'' +
                ", userPower=" + userPower +
                ", contactWay='" + contactWay + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}