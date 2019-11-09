package com.demo.datapro;

import com.demo.servlet.PageServlet;

import java.util.ArrayList;
import java.util.List;

public class PageUtils {
    int index,totPage,num;
    public PageUtils(List<Course> list, int num){
        this.index=list.size();
        this.totPage=index%num==0?index/num:index/num+1;
    }
    public int frontPage(int curPage) {
        int page=curPage-1>0?curPage-1:1;
        return page;
    }
    public int nextPage(int curPage) {
        int page=curPage+1>totPage?totPage:curPage+1;
        return page;
    }
    public int firstPage() {
        int page=1;
        return page;
    } public int finPage() {
        int page=totPage;
        return page;
    }
}
