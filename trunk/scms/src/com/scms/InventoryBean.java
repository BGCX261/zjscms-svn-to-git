package com.scms;

/**
 * material Bean
 * @author Zhujing
 */
public class InventoryBean {

    //Number of raw materials
    private String no;

    //Name of raw materials
    private String name;

    //Description of raw materials
    private String desc;

    //Quantity of raw materials
    private String quantity;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
