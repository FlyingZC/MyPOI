package com.zc.zpoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class T03Sheet
{
    public static void main(String[] args) throws Exception
    {
        //Create Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank spreadsheet创建电子表格(excel中的一页).传入sheet name为当前页的名称
        XSSFSheet spreadsheet = workbook.createSheet("Sheet Name");
        //创建一行(1代表第1行)
        XSSFRow row = spreadsheet.createRow((short) 1);
        //写入数据
        Map<String, Object[]> empinfo = new TreeMap<String, Object[]>();
        empinfo.put("1", new Object[] {"EMP ID", "EMP NAME", "DESIGNATION"});
        empinfo.put("2", new Object[] {"tp01", "Gopal", "Technical Manager"});
        empinfo.put("3", new Object[] {"tp02", "Manisha", "Proof Reader"});
        empinfo.put("4", new Object[] {"tp03", "Masthan", "Technical Writer"});
        empinfo.put("5", new Object[] {"tp04", "Satish", "Technical Writer"});
        empinfo.put("6", new Object[] {"tp05", "Krishna", "Technical Writer"});
        //Iterate over data and write to sheet
        Set<String> keyid = empinfo.keySet();
        int rowid = 0;
        for (String key : keyid)
        {
            row = spreadsheet.createRow(rowid++);//创建一行
            Object[] objectArr = empinfo.get(key);
            int cellid = 0;
            for (Object obj : objectArr)
            {
                Cell cell = row.createCell(cellid++);//创建单元格
                cell.setCellValue((String) obj);//单元格写入数据
            }
        }
        //Write the workbook in file system. 生成excel文件
        FileOutputStream out = new FileOutputStream(new File("Writesheet.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("Writesheet.xlsx written successfully");
    }
}
