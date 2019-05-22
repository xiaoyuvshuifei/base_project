package com.bp.baseProject.entity;

public class UserEntity extends BaseModel{
    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 手机号
     */
    private String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
