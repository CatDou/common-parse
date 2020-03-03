package org.osource.scd.parse.model;

import lombok.Data;

import java.util.Date;

/**
 * @author chengdu
 */
@Data
public class MergeDataVo {
    private String string;
    private String date;
    private Double doubleData;
    private Date utDate;

    private Integer id;
    private String userName;
    private Double score;
    private Long sort;
    private Date rdate;
    private String otherInfo;
}
