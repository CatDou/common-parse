package org.osource.scd.parse.model;

import lombok.Data;
import org.osource.scd.anno.Location;

import java.util.Date;

/**
 * @author chengdu
 */
@Data
public class MergeDataVo {
    @Location(sheet = 0, column = "A")
    private String string;

    @Location(sheet = 0, column = "B")
    private String date;

    @Location(sheet = 0, column = "C")
    private Double doubleData;

    @Location(sheet = 0, column = "D")
    private Date utDate;

    @Location(sheet = 1, column = "A")
    private Integer id;

    @Location(sheet = 1, column = "B")
    private String userName;

    @Location(sheet = 1, column = "C")
    private Double score;

    @Location(sheet = 1, column = "D")
    private Date rdate;
}
