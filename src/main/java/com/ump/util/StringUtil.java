package com.ump.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static net.sf.json.util.JSONUtils.isNull;

/**
 * 字符串工具
 * @author yanxinyu
 *
 */
public class StringUtil {
	
	public static final String TimeType1 = "YYYYMMddHHmmss"; 
	public static final String TimeType2 = "YYYY-MM-dd HH:mm:ss"; 
	public static final String Year = "Year";
	public static final String Month = "Month";
	public static final String Day = "Day";
	public static final String Hour = "Hour";
	public static final String Minute = "Minuter";

	/**
	 * 生成10位随机数
	 * @return
	 */
	public static String RandomString(){
		return RandomString(10);
	}

	/**
	 * 生成18位订单
	 * @return
	 */
	public static String RandomOrder(){
		//String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String text = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 29; i++) {
			int number = random.nextInt(text.length());
			sb.append(text.charAt(number));
		}
		return sb.toString();
	}
	/** 对页面参数编码 */
	public static String enCode(String str) {
		try {
			if(!isNull(str))
				return java.net.URLEncoder.encode(str, "UTF-8");
			else
				return "";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	/** 对页面参数解码 */
	public static String deCode(String str) {
		try {
			return java.net.URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 随机生成字符串
	 * @param length
	 *  字符串长度
	 * @return
	 * 2015/07/02 ouyshifeng
	 */
	public static final String randomString(int length)
	{
		Random randGen = null;
		char[] numbersAndLetters = null;
		if (length < 1) {
			return null;
		}
		if (randGen == null) {
			randGen = new Random();
			numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz"
					+ "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
		}
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
		}
		return new String(randBuffer);
	}
	/**
	 * 随机字符串 
	 * @param length
	 * 			字符串的长度
	 * @return
	 * 			随机字符串	
	 */
	public static String RandomString(int length){
		//String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String text = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			 int number = random.nextInt(text.length());
		     sb.append(text.charAt(number));
		}
		return sb.toString();
	}
	
	/**
	 * 获取当前时间
	 * @param type (如:YYYYMMddHHmmss)
	 */
	public static String GetCurrentTime(String type){
    	SimpleDateFormat sdf = new SimpleDateFormat(type); 
    	return sdf.format(new Date());
	}
	
	/**
	 * 获取前后时间(如:获取5分钟前的时间)
	 * @param timeFormat
	 * 			时间格式(如:YYYYMMddHHmmss)
	 * @param time
	 * 			输入需要提前或者延后的时间
	 * @param type 
	 * 			输入时间类型(年,月,日)
	 * @deprecated :如需要5分钟后的时间,
	 * 					type:min  //分钟
	 * 					time:5//数量
	 * 					timeFormat：YYYYMMddHHmmss//输出格式
	 * 				结果:2017120323121212
	 */
	public static String GetafterTime(String timeFormat,int time,String type){
		Calendar calendar = Calendar.getInstance();
		
		switch (type) {
		case "Year":
			calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + time);
			break;
		case "Month":
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + time);
			break;
		case "Day":
			calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + time);
			break;
		case "Hour":
			calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + time);
			break;
		case "Minuter":
			calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + time);
			break;
			
		default:
			
			break;
		}
		
		Date date = calendar.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
    	return sdf.format(date);
	}
	
	/**
	 * 计算两个时间相差值
	 * @param first 
	 * 		第一个时间  (时间格式:YYYY-MM-dd HH:mm:ss)(现在)
	 * @param second
	 * 		第二个时间  (时间格式:YYYY-MM-dd HH:mm:ss)(过去)
	 * @deprecated: first - second  
	 * 
	 * @return
	 * 		返回毫秒值
	 * @throws ParseException 
	 */
	public static String diffCalculation(String first,String second){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fir = null;
		Date sec = null;
		try {
			fir = sdf.parse(first);
			sec = sdf.parse(second);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(first+" "+second);
//		System.out.println(fir+" "+sec);
//		System.out.println(sdf.format(fir)+" "+sdf.format(sec));
		Calendar calendar= Calendar.getInstance();
		calendar.setTime(fir);
		long f = calendar.getTimeInMillis();
		calendar.setTime(sec);
		long s = calendar.getTimeInMillis();
		long time = f-s;
		return formatTime(time);
	}
	
	/** 
	 * 毫秒值转化时分秒毫秒 
	 * @param ms 
	 * 		毫秒值
	 */  
	public static String formatTime(Long ms) {  
	    Integer ss = 1000;  
	    Integer mi = ss * 60;  
	    Integer hh = mi * 60;  
	    Integer dd = hh * 24;  
	  
	    Long day = ms / dd;  
	    Long hour = (ms - day * dd) / hh;  
	    Long minute = (ms - day * dd - hour * hh) / mi;  
	    Long second = (ms - day * dd - hour * hh - minute * mi) / ss;  
	    Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;  
	      
	    StringBuffer sb = new StringBuffer();  
	    if(day > 0) {  
	        sb.append(day+"天");  
	    }  
	    if(hour > 0) {  
	        sb.append(hour+"时");  
	    }  
	    if(minute > 0) {  
	        sb.append(minute+"分");  
	    }  
	    if(second > 0) {  
	        sb.append(second+"秒");  
	    }  
	    if(milliSecond > 0) {  
	        sb.append(milliSecond+"毫秒");  
	    }  
	    return sb.toString();  
	}  
	
	
	/** 
     * 把中文转成Unicode码 
     * @param str 
     * @return 
     */  
    public static String chinaToUnicode(String str){  
    	if(str == null || "".equals(str))
    		return str;
        String result="";  
        for (int i = 0; i < str.length(); i++){  
            int chr1 = (char) str.charAt(i);  
            if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)  
                result+="\\u" + Integer.toHexString(chr1);  
            }else{  
                result+=str.charAt(i);  
            }  
        }  
        return result;  
    }

	/**
	 * 生成任意长度的随机数
	 * @param num
	 * @return
	 */
	public static String CarPlateRandombyNum(Integer num){
		StringBuffer st=new StringBuffer();
		st.append("XA");
		int a[] = new int[num];
		for(int i=0;i<a.length;i++) {
			a[i] = (int)(10*(Math.random()));
			st.append(a[i]);
		}
		return  st.toString();
	}

	/**
	 * 字符串数组转list
	 * @param array
	 * @return
	 */
		public static List<Integer> stringList2List(String[] array){
			List<Integer> resultList = new ArrayList<>(array.length);
			for (String s : array) {
				resultList.add(Integer.valueOf(s));
			}
			return resultList;
		}
	/**
	 * 根据openID生成虚拟车牌
	 * @param OpenID
	 * @return
	 */
	public static String CreatePlatebyOpenID(String OpenID){
		StringBuilder plate=new StringBuilder();
		String str=OpenID.substring(OpenID.length()-5,OpenID.length());
		plate.append("XA");
		for (int i=0;i<str.length();i++){
			//System.out.println(str.substring(i,i+1));
			Integer Ascii=Integer.valueOf(StringUtil.stringToAscii(str.substring(i,i+1)));
			//System.out.println("Ascii:"+Ascii);
			if(Ascii>=48&&Ascii<=57)//数字域
			{
				if(57-Ascii>=1) {
					Ascii = Ascii + 1;
				}
				//System.out.println("Ascii:"+Ascii);
				plate.append(StringUtil.asciiToString(Ascii.toString()));
			}
			else if(Ascii>=65&&Ascii<=90)//大写英文字母域
			{
				if(90-Ascii>=5)
				{
					Ascii=Ascii+5;
				}
				if(Ascii.equals(73))//判断是I
				{
					Ascii=49;
				}
				if(Ascii.equals(79))//判断是O
				{
					Ascii=48;
				}
				//System.out.println("Ascii:"+Ascii);
				plate.append(StringUtil.asciiToString(Ascii.toString()));

			}
			else if(Ascii>=97&&Ascii<=122)//小写英文字母域
			{
				Ascii=Ascii-32;
				if(Ascii.equals(73))//判断是I
				{
					Ascii=49;
				}
				if(Ascii.equals(79))//判断是O
				{
					Ascii=48;
				}
				//System.out.println("Ascii:"+Ascii);
				plate.append(StringUtil.asciiToString(Ascii.toString()));
			}
			//System.out.println("plate:"+plate);
		}
		return plate.toString();
	}
    /** 
     * 把Unicode码 转成中文  
     * @param utfString
     * @return 
     */ 
    public static String unicodeToChinas(String utfString){  
        StringBuilder sb = new StringBuilder();  
        int i = -1;  
        int pos = 0;  
        while(pos < utfString.length()){
        	if((i=utfString.indexOf("\\u", pos)) == pos){            
        		if(i+5 < utfString.length()){  
        			pos = i+6;  
        			sb.append((char)Integer.parseInt(utfString.substring(i+2, i+6), 16)); 
        		}  
        	}else{
        		sb.append(utfString.substring(pos, pos + 1));
        		pos ++;
        	}
        }
        return sb.toString();  
    }
	/**
	 * 字符串转换成为16进制(无需Unicode编码)
	 * @param str
	 * @return
	 */
	public static String str2HexStr(String str) {
		char[] chars = "0123456789ABCDEF".toCharArray();
		StringBuilder sb = new StringBuilder("");
		byte[] bs = str.getBytes();
		int bit;
		for (int i = 0; i < bs.length; i++) {
			bit = (bs[i] & 0x0f0) >> 4;
			sb.append(chars[bit]);
			bit = bs[i] & 0x0f;
			sb.append(chars[bit]);
			// sb.append(' ');
		}
		return sb.toString().trim();
	}
	/**
	 * 16进制直接转换成为字符串(无需Unicode解码)
	 * @param hexStr
	 * @return
	 */
	public static String hexStr2Str(String hexStr) {
		String str = "0123456789ABCDEF";
		char[] hexs = hexStr.toCharArray();
		byte[] bytes = new byte[hexStr.length() / 2];
		int n;
		for (int i = 0; i < bytes.length; i++) {
			n = str.indexOf(hexs[2 * i]) * 16;
			n += str.indexOf(hexs[2 * i + 1]);
			bytes[i] = (byte) (n & 0xff);
		}
		return new String(bytes);
	}

	/**
	 * 字符串转ASCII
	 * @param value
	 * @return
	 */
	public static String stringToAscii(String value)
	{
		StringBuffer sbu = new StringBuffer();
		char[] chars = value.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(i != chars.length - 1)
			{
				sbu.append((int)chars[i]).append(",");
			}
			else {
				sbu.append((int)chars[i]);
			}
		}
		return sbu.toString();
	}

	/**
	 * ASCII转字符串
	 * @param value
	 * @return
	 */
	public static String asciiToString(String value)
	{
		StringBuffer sbu = new StringBuffer();
		String[] chars = value.split(",");
		for (int i = 0; i < chars.length; i++) {
			sbu.append((char) Integer.parseInt(chars[i]));
		}
		return sbu.toString();
	}

	/**
	 * @Description: 实体类转成MAP
	 * @Param:
	 * @return:
	 * @Author: jin
	 * @Date: 2019/4/27
	 */
	public static Map<String,Object> object2Map(Object object){
		Map<String,Object> result=new HashMap<>();
		//获得类的的属性名 数组
		Field[]fields=object.getClass().getDeclaredFields();
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				String name = new String(field.getName());
				result.put(name, field.get(object));

			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
