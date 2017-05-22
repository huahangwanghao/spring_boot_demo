package com.wanghao.spring.boot.bean;/**
 * Created by Administrator on 2017/5/22.
 */

/**
 * 查询条件
 *
 * @author WangH
 * @create 2017-05-22 17:27
 **/
public class PageInfo {

    private int pageNo;
    
    private int pageSize;
    
    private String search;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    @Override
    public String toString() {
        return "PageInfo{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", search='" + search + '\'' +
                '}';
    }
}
