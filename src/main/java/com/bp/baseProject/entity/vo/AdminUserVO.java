package com.bp.baseProject.entity.vo;


import com.bp.baseProject.entity.AdminUser;

/**
 * 管理员用户
 *
 * @author dige
 */
public class AdminUserVO extends AdminUser {

    private int pageNum;

    private int PageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }
}
