package org.osource.scd.parse;

import org.osource.scd.constant.ParseType;

/**
 * @author chengdu
 *
 */
public class FileParseCreateor {

    private static final class FileParseHolder {
        private static final FileParse CSV_FILE_PARSER = new CsvFileParse();
        private static final FileParse EXCEL_FILE_PARSER = new ExcelFileParse();
        private static final FileParse EASY_EXCEL_PARSER = new EasyExcelParse();
    }

    public static FileParse createFileParse(ParseType parseType) {
        switch (parseType) {
            case CSV:
                return FileParseHolder.CSV_FILE_PARSER;
            case EXCEL:
                return FileParseHolder.EXCEL_FILE_PARSER;
            case EASYEXCEL:
                return FileParseHolder.EASY_EXCEL_PARSER;
            default:
                throw new IllegalArgumentException("input file type error");
        }
    }
}
