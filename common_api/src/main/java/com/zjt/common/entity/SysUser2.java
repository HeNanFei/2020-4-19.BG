package com.zjt.common.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SysUser2 {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user2.id
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user2.username
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user2.password
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user2.nickname
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    private String nickname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user2.headImgUrl
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    private String headimgurl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user2.phone
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user2.telephone
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    private String telephone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user2.email
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user2.birthday
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user2.sex
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    private Boolean sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user2.status
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    private Boolean status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user2.createTime
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user2.updateTime
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user2.id
     *
     * @return the value of sys_user2.id
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user2.id
     *
     * @param id the value for sys_user2.id
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user2.username
     *
     * @return the value of sys_user2.username
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user2.username
     *
     * @param username the value for sys_user2.username
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user2.password
     *
     * @return the value of sys_user2.password
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user2.password
     *
     * @param password the value for sys_user2.password
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user2.nickname
     *
     * @return the value of sys_user2.nickname
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user2.nickname
     *
     * @param nickname the value for sys_user2.nickname
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user2.headImgUrl
     *
     * @return the value of sys_user2.headImgUrl
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user2.headImgUrl
     *
     * @param headimgurl the value for sys_user2.headImgUrl
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user2.phone
     *
     * @return the value of sys_user2.phone
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user2.phone
     *
     * @param phone the value for sys_user2.phone
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user2.telephone
     *
     * @return the value of sys_user2.telephone
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user2.telephone
     *
     * @param telephone the value for sys_user2.telephone
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user2.email
     *
     * @return the value of sys_user2.email
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user2.email
     *
     * @param email the value for sys_user2.email
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user2.birthday
     *
     * @return the value of sys_user2.birthday
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user2.birthday
     *
     * @param birthday the value for sys_user2.birthday
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user2.sex
     *
     * @return the value of sys_user2.sex
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user2.sex
     *
     * @param sex the value for sys_user2.sex
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user2.status
     *
     * @return the value of sys_user2.status
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user2.status
     *
     * @param status the value for sys_user2.status
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user2.createTime
     *
     * @return the value of sys_user2.createTime
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user2.createTime
     *
     * @param createtime the value for sys_user2.createTime
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user2.updateTime
     *
     * @return the value of sys_user2.updateTime
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user2.updateTime
     *
     * @param updatetime the value for sys_user2.updateTime
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}