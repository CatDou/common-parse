package org.osource.scd.parse.model;

import java.util.Date;

/**
 * 基础数据类.这里的排序和excel里面的排序一致
 *
 * @author Jiaju Zhuang
 **/
public class DemoData {
    private String string;
    private String date;
    private Double doubleData;
    private Date utDate;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getDoubleData() {
        return doubleData;
    }

    public void setDoubleData(Double doubleData) {
        this.doubleData = doubleData;
    }

    public Date getUtDate() {
        return utDate;
    }

    public void setUtDate(Date utDate) {
        this.utDate = utDate;
    }
}
