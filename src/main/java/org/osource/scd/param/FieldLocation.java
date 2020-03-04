package org.osource.scd.param;

import lombok.Data;
import org.osource.scd.anno.Location;

/**
 * @author James
 */
@Data
public class FieldLocation {
    private String fieldName;

    private Location location;

    public FieldLocation() {}

    public FieldLocation(String fieldName, Location location) {
        this.fieldName = fieldName;
        this.location = location;
    }
}
