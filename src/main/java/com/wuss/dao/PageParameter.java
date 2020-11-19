package com.wuss.dao;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 */
@Data
public class PageParameter implements IPageParameter, Serializable {
    //第几页
    private int page = 1;
    //每页几条数据
    private int limit = 10;

    private int total = 10;
    //是否需要汇总
    private boolean requireTotal = false;


    public int getStart() {
        if (page <=0){
            page = 1;
        }
        return (page-1) * limit;
    }

    public int getLimit() {
        return limit;
    }

}
