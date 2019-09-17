package com.test.mytest.utils;

import com.test.mytest.bean.Cat;

import java.util.List;

public class AcctPageData {

    /**
     * 总条数
     */
    private Integer totalCount ;
    /**
     * 页码 从1开始
     */
    private Integer pageNo ;
    /**
     * 每页数量
     */
    private Integer pageSize ;
    /**
     * 起始索引
     */
    private Integer pageStart;

   // private Order order;
    private Cat cat;
    public AcctPageData() {
        super();
    }
    /**
     * 结果列表
     */
    private List<? extends Object> list;
    /**
     *
     * @param pageNo 页码 从1开始
     * @param pageSize 每页数量
     * @param list 结果列表
     * @param totalCount 总条数
     */
    public AcctPageData(Integer pageNo,Integer pageSize,List<? extends Object> list,Integer totalCount) {
//		this.recordCount = recordCount ;
        this.pageNo = pageNo ;
        this.pageSize = pageSize ;
        this.list = list ;
        this.totalCount = totalCount ;
    }
    //	public AcctPageData(Integer recordCount,Integer offset,Integer pageSize,List<? extends Object> list,Integer totalCount) {
//		this.recordCount = recordCount ;
//		this.offset = offset ;
//		this.pageSize = pageSize ;
//		this.list = list ;
//		this.totalCount = totalCount ;
//	}
    public Integer getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Object getList() {
        return list;
    }
    public void setList(List<? extends Object> list) {
        this.list = list;
    }
    public Integer getPageStart() {
        return pageStart;
    }
    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }
//    public Order getOrder() {
//        return order;
//    }
//    public void setOrder(Order order) {
//        this.order = order;
//    }
    public Cat getCar() {
        return cat;
    }
    public void setCar(Cat car) {
        this.cat = car;
    }

}
