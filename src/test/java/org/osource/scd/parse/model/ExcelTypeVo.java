package org.osource.scd.parse.model;

import lombok.Data;
import org.osource.scd.anno.Location;

import java.util.Date;

/**
 * @author chengdu
 *
 */
@Data
public class ExcelTypeVo extends ReflectVo {
    @Location(column = "E")
    private Date numDate;

    @Location(column = "F")
    private Boolean bool;
}
