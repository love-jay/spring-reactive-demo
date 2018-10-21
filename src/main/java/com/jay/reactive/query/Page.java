package com.jay.reactive.query;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {

    private long currentPage;
    private long pageSize;
    private long totalCount;
    private List<T> data;

    public Page() {
        this.currentPage = 1L;
        this.pageSize = 10L;
        this.data = new ArrayList();
    }

    public Page(long currentPage, long pageSize, long totalCount, List<T> data) {
        this(currentPage, pageSize, totalCount);
        this.data = data;
    }

    public Page(long currentPage, long pageSize, long totalCount) {
        this.currentPage = 1L;
        this.pageSize = 10L;
        this.data = new ArrayList();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public Page(long currentPage, long pageSize, List<T> data) {
        this(currentPage, pageSize);
        this.data = data;
    }

    public Page(long currentPage, long pageSize) {
        this.currentPage = 1L;
        this.pageSize = 10L;
        this.data = new ArrayList();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public long getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
