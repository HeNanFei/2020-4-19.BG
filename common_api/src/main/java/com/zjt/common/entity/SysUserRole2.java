package com.zjt.common.entity;

public class SysUserRole2 {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role2.id
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role2.sys_user_id
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    private String sysUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role2.sys_role_id
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    private String sysRoleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role2.id
     *
     * @return the value of sys_user_role2.id
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role2.id
     *
     * @param id the value for sys_user_role2.id
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role2.sys_user_id
     *
     * @return the value of sys_user_role2.sys_user_id
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public String getSysUserId() {
        return sysUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role2.sys_user_id
     *
     * @param sysUserId the value for sys_user_role2.sys_user_id
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId == null ? null : sysUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role2.sys_role_id
     *
     * @return the value of sys_user_role2.sys_role_id
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public String getSysRoleId() {
        return sysRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role2.sys_role_id
     *
     * @param sysRoleId the value for sys_user_role2.sys_role_id
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId == null ? null : sysRoleId.trim();
    }
}