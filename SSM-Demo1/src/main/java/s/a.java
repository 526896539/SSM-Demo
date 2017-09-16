package s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class a {

	//public static final String KEY_1 = "C0a9eecc5b366bde412021d4d7e5d8c4"; 
	//public static final String KEY_1 = "f247cdb592eb43ebac6ccd27f796e2d2";
	public static final String KEY_1 = "7d9fbeb43e975cd1e9477a7e5d5e192a";
    /** 
     * ���������ַ�ľ�γ������ 
     * key lng(����),lat(γ��) 
     */  
    public static Map<String,String> getGeocoderLatitude(String address){  
        BufferedReader in = null;  
        try {  
            //����ַת����utf-8��16����  
            address = URLEncoder.encode(address, "UTF-8");  
            URL tirc = new URL("http://api.map.baidu.com/geocoder?address="+ address +"&output=json&key="+ KEY_1);  
            in = new BufferedReader(new InputStreamReader(tirc.openStream(),"UTF-8"));  
            String res;  
            StringBuilder sb = new StringBuilder("");  
            while((res = in.readLine())!=null){  
                sb.append(res.trim());  
            }  
            String str = sb.toString();  
            Map<String,String> map = null;  
            if(StringUtils.isNotEmpty(str)){  
                int lngStart = str.indexOf("lng\":");  
                int lngEnd = str.indexOf(",\"lat");  
                int latEnd = str.indexOf("},\"precise");  
                if(lngStart > 0 && lngEnd > 0 && latEnd > 0){  
                    String lng = str.substring(lngStart+5, lngEnd);  
                    String lat = str.substring(lngEnd+7, latEnd);  
                    map = new HashMap<String,String>();  
                    map.put("lng", lng);  
                    map.put("lat", lat);  
                    return map;  
                }  
            }  
        }catch (Exception e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                in.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return null;  
    }  
      
    public static void main(String args[]){  
        try {  
            Map<String, String> json = a.getGeocoderLatitude("����ʡ�����������㳡");  
            System.out.println("lng : " + json.get("lng"));  
            System.out.println("lat : " + json.get("lat"));  
        }catch (Exception e ){  
           e.printStackTrace();  
        }  
    }  
  
  

	  
	}  