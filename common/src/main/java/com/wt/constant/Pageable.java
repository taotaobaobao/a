package com.wt.constant;

import java.io.Serializable;
import java.util.List;

/**
 * @author ：shan zha
 * @date ：Created in 2022/6/2 2:57 下午
 * @description：分页返回信息
 */
public class Pageable<T> implements Serializable {

    private int pageNum;

    private int pageSize;

    private int offSet;

    private int totalCount;

    private List<T> result;

    public Pageable() {
    }

    Pageable(int pageNum, int pageSize) {
        if(pageNum<=0){
            pageNum=1;
        }
        if(pageSize<=0 || pageSize>=1000){
            pageSize=20;
        }
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.offSet =  (pageNum - 1) * pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if(pageNum<=0){
            this.pageNum=1;
        }
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if(pageSize<=0 || pageSize>=1000){
            pageSize=20;
        }
        this.offSet = (pageNum - 1) * pageSize;
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    public int getOffSet() {
        return  (this.getPageNum() - 1) * this.getPageSize();
    }

    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }


}
