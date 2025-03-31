package com.fpmislata.MeLoPido.util.pagination;


import java.util.List;

public class ListWithCount<T> {
    private List<T> list;
    private long count;

    public ListWithCount(List<T> list, long count) {
        this.list = list;
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
