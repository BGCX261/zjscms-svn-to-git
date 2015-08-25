package com.scms2;

import java.io.Serializable;

/**
 * 产品类，该类描述了产品的详细信息。
 * @author Zhujing
 */
public class ComputerBean implements Serializable {

    private String number;
    
    private String name;
    
    private String comment;
    
    private String component;

    public ComputerBean() {
    }

    public ComputerBean(String parNumber, String parName, String parComment, String parComponent) {
        number = parNumber;
        name = parName;
        comment = parComment;
        component = parComponent;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
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

}
