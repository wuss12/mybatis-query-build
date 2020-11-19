package com.wuss.entity;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class SpRiskRecord implements Serializable {
    /**
     * 标准ID -- sp_risk_record.id
     * 
     */
    private Long id;

    /**
     * 客户ID -- sp_risk_record.customer_id
     * 
     */
    private String customerId;

    /**
     * 统一社会信用代码 -- sp_risk_record.org_code
     * 
     */
    private String orgCode;

    /**
     * 服务商名称 -- sp_risk_record.org_name
     * 
     */
    private String orgName;

    /**
     * 风控信息类型 -- sp_risk_record.risk_type
     * 
     */
    private String riskType;

    /**
     * 风险等级 -- sp_risk_record.risk_level
     * 
     */
    private String riskLevel;

    /**
     * 备注 -- sp_risk_record.remark
     * 
     */
    private String remark;

    /**
     * 创建日期 -- sp_risk_record.create_date
     * 
     */
    private Integer createDate;

    /**
     * 创建时间戳 -- sp_risk_record.create_datetime
     * 
     */
    private Long createDatetime;

    /**
     * sp_risk_record表的操作属性:serialVersionUID
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据字段 sp_risk_record.id的get方法 
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 数据字段 sp_risk_record.id的set方法
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 数据字段 sp_risk_record.customer_id的get方法 
     * 
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 数据字段 sp_risk_record.customer_id的set方法
     * 
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    /**
     * 数据字段 sp_risk_record.org_code的get方法 
     * 
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * 数据字段 sp_risk_record.org_code的set方法
     * 
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * 数据字段 sp_risk_record.org_name的get方法 
     * 
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 数据字段 sp_risk_record.org_name的set方法
     * 
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    /**
     * 数据字段 sp_risk_record.risk_type的get方法 
     * 
     */
    public String getRiskType() {
        return riskType;
    }

    /**
     * 数据字段 sp_risk_record.risk_type的set方法
     * 
     */
    public void setRiskType(String riskType) {
        this.riskType = riskType == null ? null : riskType.trim();
    }

    /**
     * 数据字段 sp_risk_record.risk_level的get方法 
     * 
     */
    public String getRiskLevel() {
        return riskLevel;
    }

    /**
     * 数据字段 sp_risk_record.risk_level的set方法
     * 
     */
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.trim();
    }

    /**
     * 数据字段 sp_risk_record.remark的get方法 
     * 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 数据字段 sp_risk_record.remark的set方法
     * 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 数据字段 sp_risk_record.create_date的get方法 
     * 
     */
    public Integer getCreateDate() {
        return createDate;
    }

    /**
     * 数据字段 sp_risk_record.create_date的set方法
     * 
     */
    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    /**
     * 数据字段 sp_risk_record.create_datetime的get方法 
     * 
     */
    public Long getCreateDatetime() {
        return createDatetime;
    }

    /**
     * 数据字段 sp_risk_record.create_datetime的set方法
     * 
     */
    public void setCreateDatetime(Long createDatetime) {
        this.createDatetime = createDatetime;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    /**
     * sp_risk_record数据表的操作方法: equals  
     * 
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SpRiskRecord other = (SpRiskRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getRiskType() == null ? other.getRiskType() == null : this.getRiskType().equals(other.getRiskType()))
            && (this.getRiskLevel() == null ? other.getRiskLevel() == null : this.getRiskLevel().equals(other.getRiskLevel()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateDatetime() == null ? other.getCreateDatetime() == null : this.getCreateDatetime().equals(other.getCreateDatetime()));
    }

    /**
     * sp_risk_record数据表的操作方法: hashCode  
     * 
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getRiskType() == null) ? 0 : getRiskType().hashCode());
        result = prime * result + ((getRiskLevel() == null) ? 0 : getRiskLevel().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateDatetime() == null) ? 0 : getCreateDatetime().hashCode());
        return result;
    }
}