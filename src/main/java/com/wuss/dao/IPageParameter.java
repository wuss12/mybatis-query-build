package com.wuss.dao;

public interface IPageParameter {

    //数据库查询中的 start
    int getStart();
    //数据库查询中的limit
    int getLimit();

    boolean isRequireTotal();
    //总共有多少条记录
    void setTotal(int var1);
}
