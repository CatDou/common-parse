package org.osource.scd.parse.model;

import lombok.Data;

import java.util.Date;

/**
 * @author chengdu
 * @date 2020/2/28
 */
@Data
public class ExcelTypeVo extends ReflectVo {
    private Date numDate;

    private Boolean bool;
}
