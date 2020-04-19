package org.osource.scd.parse.model;

import org.osource.scd.anno.Location;

import java.util.Date;

/**
 * @author chengdu
 *
 */
public class ExcelTypeVo extends ReflectVo {
    @Location(column = "E")
    private Date numDate;

    @Location(column = "F")
    private Boolean bool;

    public Date getNumDate() {
        return numDate;
    }

    public void setNumDate(Date numDate) {
        this.numDate = numDate;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }
}
