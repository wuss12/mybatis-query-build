package com.wuss.domain;

import lombok.Data;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.List;

/**
 */
@Data
public class PageDataList<T> implements Serializable {
    private Integer page = 1;
    private Integer pageSize = 10;
    //总数
    private long total = 0L;
    private List<T> rows ;



    public PageDataList() {
    }

    public PageDataList(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageDataList(Integer page, Integer pageSize, long total, List<T> rows) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
        this.rows = rows;
    }


    public Integer getPage() {
        Integer realPages = this.getPageCount();
        return this.page > realPages ? realPages : this.page;
    }


    public Integer getPageCount() {
        long realPages = this.total / (long)this.pageSize;
        long remain = this.total % (long)this.pageSize;
        realPages = remain > 0L ? realPages + 1L : realPages;
        return (int)realPages;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
