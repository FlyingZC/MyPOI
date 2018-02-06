package com.zc.zutil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class ExcelUtilTest
{
    @Test
    public void test01() throws FileNotFoundException
    {
        String title = "测试excel标题";

        Map<String, String> headMap = new HashMap<String, String>();
        headMap.put("name", "名字");
        headMap.put("age", "年龄");
        headMap.put("school", "学校");
        headMap.put("birth", "生日");

        List<Stu> data = new ArrayList<Stu>();
        for (int i = 0; i < 100000; i++)
        {
            Stu stu = new Stu();
            stu.setAge(i);
            stu.setBirth(new Date());
            stu.setName("zc" + i);
            stu.setSchool("sch" + i);
            data.add(stu);
        }
        String jsonString = JSON.toJSONString(data);
        JSONArray jsonArray = JSON.parseArray(jsonString);

        String datePattern = null;
        int colWidth = 10;
        OutputStream out = new FileOutputStream("D:\\excelUtilTest.xls");
        /**
         * 导出Excel 97(.xls)格式 ，少量数据
         * @param title 标题行 
         * @param headMap 属性名-列名 的映射
         * @param jsonArray 数据集
         * @param datePattern 日期格式，null则用默认日期格式
         * @param colWidth 列宽 默认 至少17个字节
         * @param out 输出流
         */
        ExcelUtil.exportExcel(title, headMap, jsonArray, datePattern, colWidth, out);
    }
}

class Stu
{
    private String name;

    private int age;

    private String school;

    private Date birth;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getSchool()
    {
        return school;
    }

    public void setSchool(String school)
    {
        this.school = school;
    }

    public Date getBirth()
    {
        return birth;
    }

    public void setBirth(Date birth)
    {
        this.birth = birth;
    }

}
