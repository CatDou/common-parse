package org.osource.scd.parse.model;

import lombok.Data;
import org.osource.scd.anno.Location;

import java.util.Date;

/**
 * @author James
 */
@Data
public class DataFormatVo {
    @Location(column = "A")
    private String name;

    @Location(column = "B")
    private String gender;

    private String province;

    private String city;

    @Location(column = "C")
    private String address;

    @Location(column = "D")
    private String phone;

    @Location(column = "E")
    private Date time;
}
