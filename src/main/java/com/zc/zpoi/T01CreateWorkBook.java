package com.zc.zpoi;

import java.io.*;
import org.apache.poi.xssf.usermodel.*;
//创建一个空白xlsx格式的Microsoft Excel工作簿。
public class T01CreateWorkBook
{
    public static void main(String[] args) throws Exception
    {
        //Create Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create file system using specific name在当前项目下生成xlsx文件
        FileOutputStream out = new FileOutputStream(new File("createworkbook.xlsx"));
        //write operation workbook using file out object 
        workbook.write(out);
        out.close();
        System.out.println("createworkbook.xlsx written successfully");
    }
}
