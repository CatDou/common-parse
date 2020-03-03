package org.osource.scd.parse.excel;

import org.apache.poi.hssf.eventusermodel.HSSFEventFactory;
import org.apache.poi.hssf.eventusermodel.HSSFRequest;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author chengdu
 *
 */
public class TestEventExcel {

    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("file/test2003.xls");
        POIFSFileSystem poifs = new POIFSFileSystem(fin);
        InputStream din = poifs.createDocumentInputStream("Workbook");
        // 构造 HSSFRequest 对象
        HSSFRequest req = new HSSFRequest();
        // 监听所有的Record
        req.addListenerForAllRecords(new EvenExcel());
        // 创建EventFactory
        HSSFEventFactory factory = new HSSFEventFactory();
        // 将输入流交给EventFactory解析生成事件
        factory.processEvents(req, din);
        // 事件处理完后关闭输入流
        fin.close();
        din.close();
        System.out.println("done.");
    }
}
