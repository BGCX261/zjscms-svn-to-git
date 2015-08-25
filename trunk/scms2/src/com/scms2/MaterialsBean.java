package com.scms2;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

/**
 * 材料类，材料的描述信息和材料列表。
 * @author Zhujing
 */
public class MaterialsBean implements Serializable {

    private String description;

    private List<PartBean> partList = new ArrayList<PartBean>();

    public MaterialsBean() {
    }

    public MaterialsBean(String parDescription) {
        description = parDescription;
    }

    public void add(PartBean parPart) {
        partList.add(parPart);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PartBean> getPartList() {
        return partList;
    }

    public void setPartList(List<PartBean> partList) {
        this.partList = partList;
    }

}
