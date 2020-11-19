package com.wuss.qry;

import com.wuss.dao.PageParameter;
import lombok.Data;

import java.io.Serializable;

@Data
public class SpRiskRecordQry extends PageParameter implements Serializable {

    private Long id;
    private String customerId;
    private String orgCode;
    private String orgName;
    private String riskType;
    private String riskLevel;
    private String remark;
    private Integer createDateStart;
    private Integer createDateEnd;
    private Long createDatetimeStart;
    private Long createDatetimeEnd;
    private long serialVersionUID;
}