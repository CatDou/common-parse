package org.osource.scd.parse.model;

import lombok.Data;

import java.util.Date;

/**
 * 基础数据类.这里的排序和excel里面的排序一致
 *
 * @author Jiaju Zhuang
 **/
@Data
public class DemoData {
    private String string;
    private String date;
    private Double doubleData;
    private Date utDate;
}
