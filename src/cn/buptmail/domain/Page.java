package cn.buptmail.domain;

import java.util.List;

/**
 * @author FIRCC
 * @version 1.0
 * @date 2020/3/12 0012 下午 04:29
 * @Notes NULL
 */
public class Page<T> {
    private int totalCount; //总记录
    private int totalPage; //页数
    private List<T> list; //每页数据
    private int currentPage; //当前页码
    private int rows; //行数

    @Override
    public String toString() {
        return "Page{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
