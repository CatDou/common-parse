package org.osource.scd.anno;

import java.lang.annotation.*;

/**
 * @author James
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface Location {
    int sheet() default 0;

    String column();
}
