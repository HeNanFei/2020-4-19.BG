package com.zjt.common.inter;

import com.zjt.common.entity.SysPermission2;
import com.zjt.common.entity.SysPermission2Example;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SysPermission2Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    long countByExample(SysPermission2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int deleteByExample(SysPermission2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int insert(SysPermission2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int insertSelective(SysPermission2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    List<SysPermission2> selectByExample(SysPermission2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    SysPermission2 selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int updateByExampleSelective(@Param("record") SysPermission2 record, @Param("example") SysPermission2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int updateByExample(@Param("record") SysPermission2 record, @Param("example") SysPermission2Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int updateByPrimaryKeySelective(SysPermission2 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_permission2
     *
     * @mbg.generated Sun Apr 19 09:54:50 CST 2020
     */
    int updateByPrimaryKey(SysPermission2 record);
}