package org.osource.scd.parse;

import org.osource.scd.constant.ParseType;

/**
 * @author chengdu
 *
 */
public class FileParseCreateor {

    private static final class FileParseHolder {
        private static final FileParse csvFileParse = new CsvFileParse();
        private static final FileParse excelFileParse = new ExcelFileParse();
        private static final FileParse easyExcelParse = new EasyExcelParse();
    }

    public static FileParse createFileParse(ParseType parseType) {
        switch (parseType) {
            case CSV:
                return FileParseHolder.csvFileParse;
            case EXCEL:
                return FileParseHolder.excelFileParse;
            case EASYEXCEL:
                return FileParseHolder.easyExcelParse;
            default:
                throw new IllegalArgumentException("input file type error");
        }
    }
}
