package org.osource.scd.parse.define;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.osource.scd.param.ParseParam;
import org.osource.scd.parse.model.ReflectVo;


/**
 * @author chengdu
 *
 */
public class ReflectVoDefineParse implements RowDefineParse {

    @Override
    public <T> void defineParse(T t, Object rowData, ParseParam parseParam) {
        if (t instanceof ReflectVo) {
            ReflectVo reflectVo = (ReflectVo) t;
            String address = "";
            String email = "";
            if (rowData instanceof String[]) {
                String[] rowArr = (String[]) rowData;
                address = rowArr[4];
                email = rowArr[5];
            } else if (rowData instanceof Row) {
                Row row = (Row) rowData;
                row.getCell(4).setCellType(CellType.STRING);
                row.getCell(5).setCellType(CellType.STRING);
                address = row.getCell(4).getStringCellValue();
                email = row.getCell(5).getStringCellValue();
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("address", address);
            jsonObject.put("email", email);
            reflectVo.setOtherInfo(jsonObject.toJSONString());
        }
    }
}
