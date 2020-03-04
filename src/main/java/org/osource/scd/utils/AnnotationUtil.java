package org.osource.scd.utils;

import org.osource.scd.anno.Location;
import org.osource.scd.param.FieldLocation;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author James
 */
public class AnnotationUtil {
    private static final Map<Class<?>, List<FieldLocation>> declaredFieldAnnoCache = new ConcurrentHashMap<>(1024);

    public static List<FieldLocation> findFieldLocationAnno(Class<?> clazz) {
        List<FieldLocation> locationList = declaredFieldAnnoCache.get(clazz);
        if (locationList == null) {
            List<Field[]> fieldList = ReflectUtil.getAllFields(clazz);
            locationList = new LinkedList<>();
            List<FieldLocation> finalLocationList = locationList;
            fieldList.forEach(fields -> {
                for (Field field : fields) {
                    Location location = field.getAnnotation(Location.class);
                    String fieldName = field.getName();
                    if (location != null && !StringUtils.isEmpty(fieldName)) {
                        FieldLocation fieldLocation = new FieldLocation(fieldName, location);
                        finalLocationList.add(fieldLocation);
                    }
                }
            });
            declaredFieldAnnoCache.put(clazz, locationList);
        }
        return declaredFieldAnnoCache.get(clazz);
    }
}
