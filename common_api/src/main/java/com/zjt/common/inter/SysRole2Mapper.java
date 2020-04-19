package com.zjt.common.inter;

import com.zjt.common.entity.SysRole2;
import com.zjt.common.entity.SysRole2Example;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SysRole2Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    long countByExample(SysRole2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int deleteByExample(SysRole2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int insert(SysRole2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int insertSelective(SysRole2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    List<SysRole2> selectByExample(SysRole2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    SysRole2 selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysRole2 record, @Param("example") SysRole2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int updateByExample(@Param("record") SysRole2 record, @Param("example") SysRole2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int updateByPrimaryKeySelective(SysRole2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int updateByPrimaryKey(SysRole2 record);
}