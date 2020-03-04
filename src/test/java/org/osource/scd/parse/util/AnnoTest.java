package org.osource.scd.parse.util;

import org.junit.Test;
import org.osource.scd.anno.Location;
import org.osource.scd.param.FieldLocation;
import org.osource.scd.parse.model.ExcelTypeVo;
import org.osource.scd.parse.model.MergeDataVo;
import org.osource.scd.parse.model.ReflectVo;
import org.osource.scd.utils.AnnotationUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class AnnoTest {

    @Test
    public void testAnno() {
        List<FieldLocation> locationList = AnnotationUtil.findFieldLocationAnno(ExcelTypeVo.class);
        for (FieldLocation location : locationList) {
            System.out.println(location);
        }
    }

    @Test
    public void testMergeDataVo() {
        List<FieldLocation> locationList = AnnotationUtil.findFieldLocationAnno(MergeDataVo.class);
        for (FieldLocation location : locationList) {
            System.out.println(location);
        }
        testConvert(locationList);
    }

    public void testConvert(List<FieldLocation> fieldLocations) {
        Map<Integer, Map<String, String>> sheetColumnMap = new HashMap<>();
        for (FieldLocation fieldLocation : fieldLocations) {
            int sheet = fieldLocation.getLocation().sheet();
            Map<String, String> fieldColumnMap = sheetColumnMap.get(sheet);
            if (fieldColumnMap == null) {
                fieldColumnMap = new HashMap<>();
            }
            fieldColumnMap.put(fieldLocation.getLocation().column(), fieldLocation.getFieldName());
            sheetColumnMap.put(sheet, fieldColumnMap);
        }
        System.out.println(sheetColumnMap);
    }
}
