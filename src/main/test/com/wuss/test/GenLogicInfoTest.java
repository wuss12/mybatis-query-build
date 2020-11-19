package com.wuss.test;

import com.wuss.dto.SpRiskRecord;
import com.wuss.service.GenLogicHelperService;

/**
 *
 */
public class GenLogicInfoTest {

    public static void main(String[] args) {
        GenLogicHelperService.generateLogic(SpRiskRecord.class);
    }
}
