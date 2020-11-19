package com.wuss.persistent.mapper;

import com.wjs.common.dao.PageDataList;
import com.wuss.entity.SpRiskRecord;
import com.wuss.entity.SpRiskRecordCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@SuppressWarnings("PMD")
public interface SpRiskRecordMapper {
    /**
     * sp_risk_record数据表的操作方法: countByExample  
     * 
     */
    int countByExample(SpRiskRecordCriteria example);

    /**
     * sp_risk_record数据表的操作方法: deleteByExample  
     * 
     */
    int deleteByExample(SpRiskRecordCriteria example);

    /**
     * sp_risk_record数据表的操作方法: deleteByPrimaryKey  
     * 
     */
    int deleteByPrimaryKey(Long id);

    /**
     * sp_risk_record数据表的操作方法: insert  
     * 
     */
    int insert(SpRiskRecord record);

    /**
     * sp_risk_record数据表的操作方法: insertSelective  
     * 
     */
    int insertSelective(SpRiskRecord record);

    /**
     * sp_risk_record数据表的操作方法: selectByExample  
     * 
     */
    List<SpRiskRecord> selectByExample(SpRiskRecordCriteria example);

    /**
     * sp_risk_record数据表的操作方法: selectByPrimaryKey  
     * 
     */
    SpRiskRecord selectByPrimaryKey(Long id);

    /**
     * sp_risk_record数据表的操作方法: lockByPrimaryKey  
     * 
     */
    SpRiskRecord lockByPrimaryKey(Long id);

    /**
     * sp_risk_record数据表的操作方法: lockByExample  
     * 
     */
    SpRiskRecord lockByExample(SpRiskRecordCriteria example);

    /**
     * sp_risk_record数据表的操作方法: pageByExample  
     * 
     */
    PageDataList<SpRiskRecord> pageByExample(SpRiskRecordCriteria example);

    /**
     * sp_risk_record数据表的操作方法: lastInsertId  
     * 线程安全的获得当前连接，最近一个自增长主键的值（针对insert操作）
     * 使用last_insert_id()时要注意，当一次插入多条记录时(批量插入)，只是获得第一次插入的id值，务必注意。
     * 
     */
    Long lastInsertId();

    /**
     * sp_risk_record数据表的操作方法: updateByExampleSelective  
     * 
     */
    int updateByExampleSelective(@Param("record") SpRiskRecord record, @Param("example") SpRiskRecordCriteria example);

    /**
     * sp_risk_record数据表的操作方法: updateByExample  
     * 
     */
    int updateByExample(@Param("record") SpRiskRecord record, @Param("example") SpRiskRecordCriteria example);

    /**
     * sp_risk_record数据表的操作方法: updateByPrimaryKeySelective  
     * 
     */
    int updateByPrimaryKeySelective(SpRiskRecord record);

    /**
     * sp_risk_record数据表的操作方法: updateByPrimaryKey  
     * 
     */
    int updateByPrimaryKey(SpRiskRecord record);

    /**
     * sp_risk_record数据表的操作方法: batchInsert  
     * 
     */
    int batchInsert(List<SpRiskRecord> records);
}