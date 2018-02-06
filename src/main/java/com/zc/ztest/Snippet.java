package com.zc.ztest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

public class Snippet
{
    @Test
    public void test01CreateExcel()
    {
        String filePath = "D:\\";
        FileUtil.buildFile(filePath, true);
        OutputStream os = null;
        //创建xls格式的excel
        HSSFWorkbook workBook = new HSSFWorkbook();
        try
        {
            os = new FileOutputStream(filePath + File.separator + "excelName" + "_import.xls");
            String[] tableNames = {"tableName1", "tableName2"};
            for (String tableName : tableNames)
            {
                HSSFSheet sheet = workBook.createSheet(tableName);
                String[] columnNames = {"a", "b", "c", "d"};
                //创建一行 标题行
                HSSFRow row0 = sheet.createRow(0);
                int columnIndex = 0;
                for (String columnName : columnNames)
                {
                    CellStyle style = getStyle(workBook);
                    Cell cell0 = row0.createCell(columnIndex++, Cell.CELL_TYPE_STRING);
                    cell0.setCellStyle(style);
                    // 每一列的列名是 数据库里的字段名(字段描述)
                    cell0.setCellValue(columnName + "(" + columnName + ")");
                }
                workBook.write(os);
                os.flush();
            }
        }
        catch (Exception e)
        {

        }
        finally
        {

        }
    }

    private CellStyle getStyle(Workbook workbook)
    {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        // 设置单元格字体
        Font headerFont = workbook.createFont(); // 字体
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(HSSFColor.RED.index);
        headerFont.setFontName("宋体");
        style.setFont(headerFont);
        style.setWrapText(true);

        // 设置单元格边框及颜色
        style.setBorderBottom((short) 1);
        style.setBorderLeft((short) 1);
        style.setBorderRight((short) 1);
        style.setBorderTop((short) 1);
        style.setWrapText(true);
        return style;
    }
}
