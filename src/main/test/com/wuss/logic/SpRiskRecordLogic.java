package com.wuss.logic;

import com.wuss.domain.PageDataList;
import com.wuss.dto.SpRiskRecord;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SpRiskRecordLogic{
    
    @Autowired
    private SpRiskRecordMapper spRiskRecordMapper;

    public PageDataList<SpRiskRecord> pageDataLists(SpRiskRecordQry qry){

        PageDataList<SpRiskRecord> pageDomain = new PageDataList<>();

        SpRiskRecordCriteria example = new SpRiskRecordCriteria();

        example.setStart(qry.getStart());
        example.setLimit(qry.getLimit());
        example.setOrderByClause("id desc");

        SpRiskRecordCriteria.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotBlank(qry.getCustomerId())){
            criteria.andCustomerIdEqualTo(qry.getCustomerId());
        }

        if (StringUtils.isNotBlank(qry.getOrgCode())){
            criteria.andOrgCodeEqualTo(qry.getOrgCode());
        }

        if (StringUtils.isNotBlank(qry.getOrgName())){
            criteria.andOrgNameEqualTo(qry.getOrgName());
        }

        if (StringUtils.isNotBlank(qry.getRiskType())){
            criteria.andRiskTypeEqualTo(qry.getRiskType());
        }

        if (StringUtils.isNotBlank(qry.getRiskLevel())){
            criteria.andRiskLevelEqualTo(qry.getRiskLevel());
        }

        if (StringUtils.isNotBlank(qry.getRemark())){
            criteria.andRemarkEqualTo(qry.getRemark());
        }

         if (qry.getId() != null){
            criteria.andIdEqualTo(qry.getId());
        }


        if (qry.getCreateDateStart() != null){
            criteria.andCreateDateGreaterThanOrEqualTo(qry.getCreateDateStart());
        }

        if (qry.getCreateDateEnd() != null){
            criteria.andCreateDateLessThanOrEqualTo(qry.getCreateDateEnd());
        }

        if (qry.getCreateDatetimeStart() != null){
            criteria.andCreateDatetimeGreaterThanOrEqualTo(qry.getCreateDatetimeStart());
        }

        if (qry.getCreateDatetimeEnd() != null){
            criteria.andCreateDatetimeLessThanOrEqualTo(qry.getCreateDatetimeEnd());
        }


        int count = spRiskRecordMapper.countByExample(example);
        pageDomain.setTotal(count);

        if (count == 0){
            return pageDomain;
        }

        pageDomain.setRows(spRiskRecordMapper.selectByExample(example));
        return pageDomain;
    }
}