package org.osource.scd.parse.model;

import lombok.Data;
import org.osource.scd.anno.Location;

import java.util.Date;

/**
 * @author chengdu
 *
 */
@Data
public class ReflectVo {
    @Location(column = "A")
    private Integer id;

    @Location(column = "B")
    private String userName;

    @Location(column = "C")
    private Double score;

    private Long sort;

    @Location(column = "D")
    private Date date;

    private String otherInfo;
}
