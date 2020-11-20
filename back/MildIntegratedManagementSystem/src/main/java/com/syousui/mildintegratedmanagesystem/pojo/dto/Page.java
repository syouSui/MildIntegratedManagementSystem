package com.syousui.mildintegratedmanagesystem.pojo.dto;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : Page.java
 * @PackageLoaction : com.syousui.mildintegratedmanagesystem.pojo.dto
 * @createTime : 2020-11-19 20:20:00 星期四
 * @Description : TODO
 */

/**
 * 分页返回结果
 */
public class Page {
    //    当前页码
    private int pageNum;
    //    每页数量
    private int pageSize;
    //    页码总数
    private int pageTotal;
    //    记录总数
    private long totalSize;
    //    数据模型
    private List<?> content;

    public Page ( ) {
    }
    public Page ( int pageNum, int pageSize, int pageTotal, long totalPages, List<?> content ) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageTotal = pageTotal;
        this.totalSize = totalPages;
        this.content = content;
    }
    public Page ( PageInfo<?> pageInfo ) {
        this.pageNum = pageInfo.getPageNum( );
        this.pageSize = pageInfo.getPageSize( );
        this.pageTotal = pageInfo.getPages( );
        this.totalSize = pageInfo.getTotal( );
        this.content = pageInfo.getList( );
    }

    public int getPageNum ( ) {
        return pageNum;
    }
    public void setPageNum ( int pageNum ) {
        this.pageNum = pageNum;
    }
    public int getPageSize ( ) {
        return pageSize;
    }
    public void setPageSize ( int pageSize ) {
        this.pageSize = pageSize;
    }
    public long getTotalSize ( ) {
        return totalSize;
    }
    public void setTotalSize ( long totalSize ) {
        this.totalSize = totalSize;
    }
    public int getPageTotal ( ) {
        return pageTotal;
    }
    public void setPageTotal ( int pageTotal ) {
        this.pageTotal = pageTotal;
    }
    public List<?> getContent ( ) {
        return content;
    }
    public void setContent ( List<?> content ) {
        this.content = content;
    }
}
