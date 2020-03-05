package org.osource.scd.parse.model;

import lombok.Data;
import org.osource.scd.anno.Location;

/**
 * @author chengdu
 *
 */
@Data
public class UserInfo {
    @Location(column = "A")
    private String name;
    @Location(column = "B")
    private String gender;
    @Location(column = "C")
    private String num;
}
