package com.scms2;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * 产品类，产品的描述与产品列表对象。
 * @author Zhujing
 */
public class ProductsBean implements Serializable {

    private String description;

    private List<ComputerBean> computerList = new ArrayList<ComputerBean>();

    public ProductsBean() {
    }
    
    public ProductsBean(String parDescription) {
        description = parDescription;
    }

    public void add(ComputerBean parComputer) {
        computerList.add(parComputer);
    }

    public List<ComputerBean> getComputerList() {
        return computerList;
    }

    public void setComputerList(List<ComputerBean> computerList) {
        this.computerList = computerList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
