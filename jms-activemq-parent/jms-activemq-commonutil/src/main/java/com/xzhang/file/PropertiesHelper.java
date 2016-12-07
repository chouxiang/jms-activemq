/**
 * File: PropertiesHelper.java
 * Description: Properties文件处理的辅助类
 * Copyright 2010 GamaxPay. All rights reserved
 *  
 */
package com.xzhang.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * <p>Properties文件操作的辅助类</p>
 * Propertes文件内容读取
 * 写入内容到Properties文件中
 * @author jacky
 *
 */
public class PropertiesHelper {

	
	private static Logger logger = Logger.getLogger(PropertiesHelper.class.getName());
	
	/**
	 * 该类不能被new
	 */
	private  PropertiesHelper(){		
	}
	
	/**
	 * 根据提供的文件路径, 获取所有Properties里面内容
	 * @param filepath					导入Properties的文件路径
	 * @return	Map<String, String>		Map类型, key, value
	 * @throws IOException				在夺取properties文件的时候会发生IOException
	 * @throws FileNotFoundException	如果读取的文件不存在会抛出此异常
	 */
	public static Map<String, String> loadAllProperties(String filepath) throws FileNotFoundException{
		
		//如果文件路径不存在, 抛出异常
		File file = new File(filepath);
	 	if(!file.exists()){
	 		throw new FileNotFoundException("file not existed");
	 	}
        InputStream in = new BufferedInputStream (new FileInputStream(filepath));        
        return loadAllProperties(in);
	}
	
	/**
	 * 根据提供的输入流, 获取所有Properties里面内容
	 * @param inputstream	输入流
	 * @return	Map<String, String>		Map类型, key, value				
	 */
	public static Map<String, String> loadAllProperties(InputStream inputstream){
		
		Properties props = new Properties();	 	
        try{
        	props.load(inputstream);
        }catch(IOException ioe){
        	logger.error("loadAllContents(InputStream inputstream) create IOException", ioe);
        	throw new RuntimeException(ioe);
        }
        
        //将Properties里面的key, value放到map里面去
        Map<String, String> map = new HashMap<String, String>();
        Enumeration en = props.propertyNames();
        while(en.hasMoreElements()){
        	String key = (String)en.nextElement();
        	String value = (String)props.get(key);
        	map.put(key, value);
        }
        
        return map;
	}
	
	/**
	 * 根据提供的Properties文件路径和key, 获取key对应的内容
	 * @param filepath					读取properties文件的路径
	 * @param key						properties文件中的key
	 * @return							key对应的value
	 * @throws FileNotFoundException	如果提供的properties的文件路径有误抛出此异常
	 */
	public static String getProperty(String filepath, String key) throws FileNotFoundException{
		
		//如果文件路径不存在, 抛出异常
		File file = new File(filepath);
	 	if(!file.exists()){
	 		throw new FileNotFoundException("file not existed");
	 	}
	 	
        InputStream in = new BufferedInputStream (new FileInputStream(filepath));        
        return getProperty(in, key);
	}
	
	/**
	 * 根据提供的输入流, 和key 获取key的内容
	 * @param inputstream	提供Properties文件输入流
	 * @param key			获取内容的key
	 * @return				返回key对应的内容
	 */
	public static String getProperty(InputStream inputstream, String key){
		
		Properties props = new Properties();	 	
        try{
        	props.load(inputstream);
        }catch(IOException ioe){
        	logger.error("loadAllContents(InputStream inputstream) create IOException", ioe);
        	throw new RuntimeException(ioe);
        }finally{
        	try {
				inputstream.close();
			} catch (IOException e) {
				logger.error("loadAllContents(InputStream inputstream) create IOException", e);
	        	throw new RuntimeException(e);
			}
        	
        }
        
        return props.getProperty(key);
	}
	
	/**
	 * 将key=value写入到文件中
	 * @param filepath	将要被写入的文件路径
	 * @param key		写入的key
	 * @param value		写入的value
	 */
	public static void store(String filepath, String key, String value){		
		
		//如果文件不存在, 创建此文件
		File file = new File(filepath);
	 	
    	
	 		try {
	 			if(!file.exists()){
	 				file.createNewFile();
	 			}
				OutputStream fos = new FileOutputStream(filepath);
				store(fos, key, value);
				
			} catch (IOException ioe) {
				logger.error("store(String filepath, String key, String value) create IOException", ioe);
				throw new RuntimeException(ioe);				
			}
	 	
	}
	
	/**
	 * 批量存入内容到Properties文件
	 * 文件路径如果不存在, 将被创建一个
	 * @param filepath	被写入的文件路径  
	 * @param map
	 */
	public static void store(String filepath, Map<String, String> map){
		
		//如果文件不存在, 创建此文件
		File file = new File(filepath);
	 		try {
	 			if(!file.exists()){
	 				file.createNewFile();
	 			}
				OutputStream fos = new FileOutputStream(filepath);
				store(fos, map);
				
			} catch (IOException ioe) {
				logger.error("store(String filepath, String key, String value) create IOException", ioe);
				throw new RuntimeException(ioe);				
			}
		
	}
	
	
	/**
	 * 将key=value写入到流中
	 * @param outputstream	将要被写入的流
	 * @param key			写入的key
	 * @param value			写入的value
	 */
	public static void store(OutputStream outputstream, String key, String value){		
	
		Properties prop = new Properties();
		try{
			prop.setProperty(key, value);
			prop.store(outputstream, "Update '" + key + "' value");
		
		}catch(IOException ioe){
			logger.error("store properties into stream create IOException", ioe);
			throw new RuntimeException(ioe);	
		}
	}
	
	/**
	 * 批量将文件写入到流中
	 * @param outputstream	将要被写入的流 
	 * @param map			批量被写入的内容 
	 */
	public static void store(OutputStream outputstream, Map<String, String> map){
		
		Properties prop = new Properties();
		try{
			Set<String> keys = map.keySet();
			
			for(String key : keys){
				String value = map.get(key);
				prop.setProperty(key, value);
			}
			prop.store(outputstream, "Update all properties");
		
		}catch(IOException ioe){
			logger.error("store properties into stream create IOException", ioe);
			throw new RuntimeException(ioe);	
		}finally{
			try {
				outputstream.close();
			} catch (IOException ioe) {
				logger.error("store properties into stream create IOException", ioe);
				throw new RuntimeException(ioe);
			}
		}
		
		
	}
	
}
