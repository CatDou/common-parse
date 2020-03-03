package org.osource.scd.parse;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author chengdu
 *
 */
public class StrTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private String split_regex = ",|\t";

    private String[] splitCsvLine(String inputLine) {
        if (!inputLine.contains(",") && !inputLine.contains("\t")) {
            throw new IllegalArgumentException("input csv line unknown delimiter");
        }
        return inputLine.split(split_regex);
    }

    @Test
    public void splitTest() {
        String[] inputArr = splitCsvLine("1,2,3,4,5");
        Assert.assertEquals(5, inputArr.length);
        String[] inputArr2 = splitCsvLine("1\t2\t3\t4\t5");
        Assert.assertEquals(5, inputArr2.length);
    }

    @Test
    public void testMap() {
        Map<Integer, String> map = new HashMap<>(16);
        map.put(1, "cd");
        map.put(2, "chengdu");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        Integer column;
        String value;
        for(Map.Entry<Integer, String> entry : entrySet) {
            column = entry.getKey();
            value = entry.getValue();
            System.out.println(column);
            System.out.println(value);
        }
    }

    @Test
    public void testErrorLine() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("input csv line unknown delimiter");
        String csvLine = "123456";
        String[] leneArr = splitCsvLine(csvLine);
    }
}
