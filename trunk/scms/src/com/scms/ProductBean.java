package com.scms;

import java.util.List;

/**
 * product Bean
 * @author Zhujing
 */
public class ProductBean {

    //Number of product
    private String no;

    //Name of product
    private String name;

    //Description of product
    private String desc;

    //Product raw material required for
    private String invNo;

    //Product raw material object
    private List<InventoryBean> invList;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<InventoryBean> getInvList() {
        return invList;
    }

    public void setInvList(List<InventoryBean> invList) {
        this.invList = invList;
    }

    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

}
