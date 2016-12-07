package com.xzhang.string;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.RandomStringUtils;


/**
 * 
 * @author Willence Shen
 *
 */
public class StringUtil {
	private StringUtil() {}
	
	/**
	 * 传入不同的手机号，获取到8位的随机数
	 * @param mobile
	 * @return
	 */
	public String initPassword(String mobile) {
		String password = RandomStringUtils.randomNumeric(8);
		return password;				
	}

	/**
	 * 获取到UUID
	 * @return
	 */
	public String getUUID(){
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 去掉字符串的所有空格
	 * @param sourceStr 待处理的字符串
	 * @return 去掉所有空格后的字符串
	 */
	public static String removeAllSpace(String sourceStr) {
		Pattern pattern = Pattern.compile("\\s*", Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(sourceStr);
		sourceStr = matcher.replaceAll("");
		return sourceStr;
	}
	
	/**
	 * 格式话手机号码.
	 * 该方法主要用于将手机号码隐藏显示，例如：139××××2039
	 * mobileFormat: 
	 *  
	 * @param mobile
	 * @return
	 */
	public static String mobileFormat(String mobile)
	{
	    if(mobile==null || mobile.equals(""))
	    {
	        throw new IllegalArgumentException("手机号码格式错误.mobile:"+mobile);
	    }
	    int start = (mobile.length()/2)-(mobile.length()/4);
	    int end = (mobile.length()/2)+(mobile.length()/4);
	    StringBuffer sb = new StringBuffer(mobile.subSequence(0, start));
	    for(int i=start;i<end;i++)
	    {
	        sb.append("*");
	    }
	    sb.append(mobile.substring(end));
	    return sb.toString();
	}
	
	/**
	 * 验证相应国家的手机格式
	 * @param mobile 手机号
	 * @param regExp 手机格式的正则表达式
	 * @return 匹配返回true / 不匹配 返回false
	 */
	public static boolean isMobileFormatFine(String mobile, String regExp) {
		mobile = removeAllSpace(mobile);
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(mobile);
		return m.find();
	}
	
	/**
	 * 验证字符串是否在指定的数字中存在.
	 * strIn: 
	 *  
	 * @param arry
	 * @param str
	 * @return
	 */
	public static boolean strIn(String[] arry,String str)
	{
	    if(str==null)
	    {/**默认空串存在于任何字符串数组中.*/
	        return true;
	    }
	    if(arry!=null)
	    {
	        for(String s:arry)
	        {
	            if(str.equals(s))
	            {
	                return  true;
	            }
	        }
	    }
	    //默认返回false,表示不存在.
	    return false;
	}
	/**
	 * 判断字符串是否为空, 如果是纯空格组成的字符串也认为是空
	 * @param str
	 * @return 为空返回true / 不为空返回false
	 */
	public static boolean isEmptyOrNull(String str) {
		if (null == str || "".equals(removeAllSpace(str))) {
			return true;
		}
		return false;
	}
	
	/**
	 * 返回字符串的末尾N未
	 * @param str 字符串
	 * @param length 子串长度
	 * @return
	 */
	public static String lastNChar(String str ,int length)
	{
	    if(str==null)
	    {
	        return "";
	    }
	    if(str.length()<=length)
	    {
	        return str;
	    }
	    return str.substring(str.length()-length, str.length());
	}
	
	/***/
	public static String urlEncode(String str)
    {
	    try
        {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e)
        {
            return str;
            
        }
    }
	
	/**
	 * 正则表达式提取.
	 * @param reg     待提取的正则表达式
	 * @param context 待匹配的文本内容. 
	 * @return 正则表达式匹配后的分组1.
	 */
	public static String regMatch(String reg,String context)
	{
	    try{
	    Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(context);
        matcher.find();
        return matcher.group(1);
	    }catch(Exception e)
	    {
	        return null;
	    }
	}
	 public static String nullToStrTrim(String str) {

	    	if (str == null) {
	        	return "";
	        }

	        return str.trim();
	    }
	
	public static void main(String[] args) {
	   String context="<?xml version=\"1.0\" encoding=\"GB2312\"?><fill version=\"1.0\"><items><item name=\"prodid\" value=\"60007\"/><item name=\"orderid\" value=\"4567uik\"/><item name=\"tranid\" value=\"EDO0141105102829310098\"/><item name=\"resultno\" value=\"1010\"/><item name=\"mark\" value=\"\"/><item name=\"verifystring\" value=\"b9226aba4f265da0260e4d95cd8ec96a\"/></items></fill>";
	   String reg=".*<item\\s+name=\"resultno\"\\s+value=\"(\\d+)\"\\s+/>.*";
	   System.out.println(regMatch(reg,context));
			
	}
}
