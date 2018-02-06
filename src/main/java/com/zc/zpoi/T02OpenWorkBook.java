package com.zc.zpoi;

import java.io.*;
import org.apache.poi.xssf.usermodel.*;

//读取excel,获取工作簿的输入流,创建XSSFWorkbook对象
public class T02OpenWorkBook
{
    public static void main(String args[]) throws Exception
    {
        File file = new File("createworkbook.xlsx");
        FileInputStream fip = new FileInputStream(file);
        //Get the workbook instance for XLSX file,从已有的xls文件创建XSSFWorkbook对象 
        XSSFWorkbook workbook = new XSSFWorkbook(fip);
        if (file.isFile() && file.exists())
        {
            System.out.println("openworkbook.xlsx file open successfully.");
        }
        else
        {
            System.out.println("Error to open openworkbook.xlsx file.");
        }
    }
}
