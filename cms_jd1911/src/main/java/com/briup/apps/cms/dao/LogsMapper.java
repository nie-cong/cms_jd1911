package com.briup.apps.cms.dao;

import com.briup.apps.cms.bean.Logs;
import com.briup.apps.cms.bean.LogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_logs
     *
     * @mbg.generated Mon Nov 18 15:02:16 CST 2019
     */
    long countByExample(LogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_logs
     *
     * @mbg.generated Mon Nov 18 15:02:16 CST 2019
     */
    int deleteByExample(LogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_logs
     *
     * @mbg.generated Mon Nov 18 15:02:16 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_logs
     *
     * @mbg.generated Mon Nov 18 15:02:16 CST 2019
     */
    int insert(Logs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_logs
     *
     * @mbg.generated Mon Nov 18 15:02:16 CST 2019
     */
    int insertSelective(Logs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_logs
     *
     * @mbg.generated Mon Nov 18 15:02:16 CST 2019
     */
    List<Logs> selectByExampleWithBLOBs(LogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_logs
     *
     * @mbg.generated Mon Nov 18 15:02:16 CST 2019
     */
    List<Logs> selectByExample(LogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_logs
     *
     * @mbg.generated Mon Nov 18 15:02:16 CST 2019
     */
    Logs selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_logs
     *
     * @mbg.generated Mon Nov 18 15:02:16 CST 2019
     */
    int updateByExampleSelective(@Param("record") Logs record, @Param("example") LogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_logs
     *
     * @mbg.generated Mon Nov 18 15:02:16 CST 2019
     */
    int updateByExampleWithBLOBs(@Param("record") Logs record, @Param("example") LogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_logs
     *
     * @mbg.generated Mon Nov 18 15:02:16 CST 2019
     */
    int updateByExample(@Param("record") Logs record, @Param("example") LogsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_logs
     *
     * @mbg.generated Mon Nov 18 15:02:16 CST 2019
     */
    int updateByPrimaryKeySelective(Logs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_logs
     *
     * @mbg.generated Mon Nov 18 15:02:16 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(Logs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_logs
     *
     * @mbg.generated Mon Nov 18 15:02:16 CST 2019
     */
    int updateByPrimaryKey(Logs record);
}