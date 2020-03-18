package org.osource.scd.parse.define;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.osource.scd.param.ParseParam;
import org.osource.scd.parse.model.ReflectVo;
import org.osource.scd.utils.ExcelUtil;


/**
 * @author chengdu
 *
 */
public class ReflectVoDefineParse implements RowDefineParse<ReflectVo> {

    @Override
    public void defineParse(ReflectVo t, Object rowData, ParseParam parseParam) {
        String address = "";
        String email = "";
        if (rowData instanceof String[]) {
            String[] rowArr = (String[]) rowData;
            address = rowArr[4];
            email = rowArr[5];
        } else if (rowData instanceof Row) {
            Row row = (Row) rowData;
            address = ExcelUtil.getCellValue(row, 4);
            email = ExcelUtil.getCellValue(row, 5);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("address", address);
        jsonObject.put("email", email);
        t.setOtherInfo(jsonObject.toJSONString());
    }
}
