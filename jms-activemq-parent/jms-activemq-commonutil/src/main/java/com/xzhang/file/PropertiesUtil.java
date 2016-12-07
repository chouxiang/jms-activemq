/**
 *  File: PropertiesUtil.java
 *  Description:
 *      该类主要用于处理Properties文件，实现properties文件之间的合并.
 *
 *  Copyright 2004-2008 Gamax Interactive. All rights reserved.
 *  Date        Author      Changes
 *  2011-4-15		CaoHui      创建
 */
package com.xzhang.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
/**
 * 
 * <p>Properties工具类</p>
 * 
 * <p>该类主要用于处理Properties文件，实现properties文件之间的合并.</p>
 * 
 * @author CaoHui
 * 
 */
public class PropertiesUtil
{
    /**
     * 合并Properties文件
     *  该方法主要用于将源文件合并到目标文件中，处理逻辑如下：
     *   如果源文件和目标文件存在相同的条目，则采用源文件的条目覆盖目标文件的条目.
     *   如果仅仅源文件存在的条目，则则将源文件的条目添加到目标文件.
     * @param from 源文件
     * @param to 目标文件
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public static void merge(String from,String to) throws FileNotFoundException, IOException
    {
        Properties f = new Properties();
        f.load(new FileInputStream(from));
        Properties t = new Properties();
        t.load(new FileInputStream(to));
        for(Map.Entry row:f.entrySet()){
            t.put(row.getKey(),row.getValue());
        }
        t.store(new FileOutputStream(to), "Merged at "+new Date().toString());
    }
    
    public static void diff(String bakFilePath,String filePath) throws FileNotFoundException, IOException{
    	Properties f = new Properties();
        f.load(new FileInputStream(bakFilePath));
        Properties t = new Properties();
        t.load(new FileInputStream(filePath));
        StringBuffer sb0 = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        StringBuffer sb3 = new StringBuffer();
        int i0 = 0;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        
        Set<Object> keys = new HashSet();
        keys.addAll(f.keySet());
        keys.addAll(t.keySet());
        for (Object key: keys){
			if(f.containsKey(key)&&t.containsKey(key)){
				if(!f.get(key).equals(t.get(key))){
					i0++;
					sb0.append(key+" : \r\n"+
							"========>"+t.get(key)+"\r\n"+
							"bak=====>"+f.get(key)+"\r\n\r\n");
				}else{
					i3++;
					sb3.append(key+" : \r\n"+
							"========>"+t.get(key)+"\r\n"+
							"bak=====>"+f.get(key)+"\r\n\r\n");
				}
			}else if(f.containsKey(key)&&!t.containsKey(key)){
				i1++;
				sb1.append(key+" : "+f.get(key)+"\r\n");
			}else if(!f.containsKey(key)&&t.containsKey(key)){
				i2++;
				sb2.append(key+" : "+t.get(key)+"\r\n");
			}
		}
        System.out.println("有所修改的 ("+i0+"): ");
        System.out.println(sb0.toString());
        System.out.println("bak有本地没有的  ("+i1+"): ");
        System.out.println(sb1.toString());
        System.out.println("本地有bak没有的 ("+i2+") : ");
        System.out.println(sb2.toString());
        //System.out.println("没有修改的  ("+i3+"): ");
        //System.out.println(sb3.toString());
    }
    
    /**
     * 
     * @param args 需要输入两个参数，分别是合并的源文件，和目标文件。集将源文件覆盖到目标文件上。
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
//        String fpre = "D:\\workspace\\ws_gamaxpay\\gamaxpaywebsite\\src\\i18nbak";
//        String tpre = "D:\\workspace\\ws_gamaxpay\\gamaxpaywebsite\\src\\i18n";
    	  String fpre = "D:\\workspace\\ws_gamaxpay\\gamaxpaywebsite\\src\\i18nbak";
    	  String tpre = "D:\\workspace\\ws_gamaxpay\\gamaxpaywebsite\\src\\i18n";
          //merge(fpre+"\\messages_de.properties",tpre+"\\messages_de.properties");
          //merge(fpre+"\\messages_en.properties",tpre+"\\messages_en.properties");
//        merge(fpre+"\\messages.properties.bak",tpre+"\\messages.properties");
//        merge(fpre+"\\messages_zh_CN.properties.bak",tpre+"\\messages_zh_CN.properties");
        //diff(fpre+"\\messages_de.properties.bak",tpre+"\\messages_de.properties");
        //diff(fpre+"\\messages_en.properties",tpre+"\\messages_en.properties");
        //diff(fpre+"\\messages_de.properties",tpre+"\\messages_de.properties");
        //diff(fpre+"\\messages_zh_CN.properties.bak",tpre+"\\messages_zh_CN.properties");
    }
}
