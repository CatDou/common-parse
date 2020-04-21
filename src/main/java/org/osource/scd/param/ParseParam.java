package org.osource.scd.param;

import org.osource.scd.constant.ParseType;
import org.osource.scd.parse.define.RowDefineParse;
import org.osource.scd.parse.consumer.DataConsumer;
import org.osource.scd.parse.error.DefaultErrorRecord;
import org.osource.scd.parse.error.ErrorRecord;
import org.osource.scd.parse.define.CellFormat;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author chengdu
 *
 */
public class ParseParam {
    private int startLine;

    private int sheetNum;

    private Map<String, Method> fieldSetterMap;

    private RowDefineParse businessDefineParse;

    private String encode;

    private ErrorRecord errorRecord;

    private CellFormat cellFormat;

    private ParseType parseType;

    private DataConsumer dataConsumer;

    private int batchNum = 1000;

    public ParseParam() {
        errorRecord = new DefaultErrorRecord(new StringBuilder());
    }

    public ParseParam setStartLine(int startLine) {
        this.startLine = startLine;
        return this;
    }

    public ParseParam setSheetNum(int sheetNum) {
        this.sheetNum = sheetNum;
        return this;
    }

    public ParseParam setFieldSetterMap(Map<String, Method> fieldSetterMap) {
        this.fieldSetterMap = fieldSetterMap;
        return this;
    }

    public ParseParam setBusinessDefineParse(RowDefineParse businessDefineParse) {
        this.businessDefineParse = businessDefineParse;
        return this;
    }

    public ParseParam setEncode(String encode) {
        this.encode = encode;
        return this;
    }

    public ParseParam setErrorRecord(ErrorRecord errorRecord) {
        this.errorRecord = errorRecord;
        return this;
    }

    public ParseParam setCellFormat(CellFormat cellFormat) {
        this.cellFormat = cellFormat;
        return this;
    }

    public ParseParam setParseType(ParseType parseType) {
        this.parseType = parseType;
        return this;
    }

    public ParseParam setBatchNum(int batchNum) {
        this.batchNum = batchNum;
        return this;
    }

    public ParseParam setDataConsumer(DataConsumer dataConsumer) {
        this.dataConsumer = dataConsumer;
        return this;
    }

    public int getStartLine() {
        return startLine;
    }

    public int getSheetNum() {
        return sheetNum;
    }

    public Map<String, Method> getFieldSetterMap() {
        return fieldSetterMap;
    }

    public RowDefineParse getBusinessDefineParse() {
        return businessDefineParse;
    }

    public String getEncode() {
        return encode;
    }

    public ErrorRecord getErrorRecord() {
        return errorRecord;
    }

    public CellFormat getCellFormat() {
        return cellFormat;
    }

    public ParseType getParseType() {
        return parseType;
    }

    public DataConsumer getDataConsumer() {
        return dataConsumer;
    }

    public int getBatchNum() {
        return batchNum;
    }
}
