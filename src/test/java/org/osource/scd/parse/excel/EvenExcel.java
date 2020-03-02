package org.osource.scd.parse.excel;

import org.apache.poi.hssf.eventusermodel.HSSFListener;
import org.apache.poi.hssf.record.*;

/**
 * @author chengdu
 * @date 2020/2/29
 */
public class EvenExcel implements HSSFListener {

    private SSTRecord sstrec;

    // 实现接口方法
    public void processRecord(Record record) {
        switch (record.getSid()) {
            case BOFRecord.sid: // Beginning Of File
                BOFRecord bof = (BOFRecord) record;
                if (bof.getType() == bof.TYPE_WORKBOOK) {
                    System.out.println("Encountered workbook");
                } else if (bof.getType() == bof.TYPE_WORKSHEET) {
                    System.out.println("Encountered sheet reference");
                }
                break;
            case BoundSheetRecord.sid:
                BoundSheetRecord bsr = (BoundSheetRecord) record;
                System.out.println("New sheet named:" + bsr.getSheetname());
                break;
            case RowRecord.sid: // 行
                RowRecord rowrec = (RowRecord) record;
                System.out.println("first column:" + rowrec.getFirstCol() + ","
                        + "last column:" + rowrec.getLastCol());
                break;
            case NumberRecord.sid: // 数字单元格
                NumberRecord numrec = (NumberRecord) record;
                System.out.println("Row:"+numrec.getRow() + "," +
                        "Column:" + numrec.getColumn() + "," +
                        "Number value:" + numrec.getValue());
                break;
            case SSTRecord.sid: // Static String Table Record
                sstrec = (SSTRecord) record;
                System.out.println("String table value:");
                for (int k = 0; k < sstrec.getNumUniqueStrings(); k++) {
                    System.out.println(k + " = " + sstrec.getString(k));
                }
                break;
            case LabelSSTRecord.sid:
                LabelSSTRecord lrec = (LabelSSTRecord) record;
                System.out.println("Row:" + lrec.getRow() + "," +
                                "Column:" + lrec.getColumn() + "," +
                        "String cell value:" + sstrec.getString(lrec.getSSTIndex()));
                break;
        }
    }
}
