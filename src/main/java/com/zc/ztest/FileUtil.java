package com.zc.ztest;

import java.io.File;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author chenbuquan
 * @version [版本号, 2016年10月12日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class FileUtil
{
    /**
     * <一句话功能简述> <功能详细描述>
     * 
     * @param fileName 文件名 带路径
     * @param isDirectory 是否为路径
     * @return file
     * @see [类、类#方法、类#成员]
     */
    public static File buildFile(String fileName, boolean isDirectory)
    {
        
        File target = new File(fileName);
        
        if (isDirectory)
        {
            
            target.mkdirs();
            
        }
        else
        {
            
            if (!target.getParentFile().exists())
            {
                
                target.getParentFile().mkdirs();
                
                target = new File(target.getAbsolutePath());
                
            }
            
        }
        
        return target;
        
    }
}
