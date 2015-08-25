package com.scms2;

import java.io.Serializable;

/**
 * 部件对象，部件的详细信息。
 * @author Zhujing
 */
public class PartBean implements Serializable {

    private String number;
    
    private String name;
    
    private String comment;
    
    private int quantity;

    public PartBean() {
    }

    public PartBean(String parNumber, String parName, String parComment, int parQuantity) {
        number = parNumber;
        name = parName;
        comment = parComment;
        quantity = parQuantity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
