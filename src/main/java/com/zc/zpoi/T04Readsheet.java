package com.zc.zpoi;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//读取一页工作簿
public class T04Readsheet
{
    static XSSFRow row;

    public static void main(String[] args) throws Exception
    {
        FileInputStream fis = new FileInputStream(new File("WriteSheet.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);//第0页
        Iterator<Row> rowIterator = spreadsheet.iterator();//遍历页中的每一行
        while (rowIterator.hasNext())
        {
            row = (XSSFRow) rowIterator.next();//行
            Iterator<Cell> cellIterator = row.cellIterator();//单元格
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                switch (cell.getCellType())
                {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + " \t\t ");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + " \t\t ");
                        break;
                }
            }
            System.out.println();
        }
        fis.close();
    }
}
