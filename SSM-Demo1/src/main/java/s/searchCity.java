package s;

import java.net.URL;

import net.sf.json.JSONObject;



public class searchCity {
	
	public static String[] getArea(String log, String lat ){  
		
		return getAreaArrayByLocation(log, lat);
	}
	
	public static String[] getAreaArrayByLocation(String log, String lat ){
		String ak="Y9j1rfrEsLVlzrDZ4RHmZ7OGXk28FNKB";
        String urlString = "http://api.map.baidu.com/geocoder/v2/?location="+lat+","+log+"&output=json&pois=1&ak="+ak+"&coordtype=bd09ll";  
        String res = "";     
        try {     
            URL url = new URL(urlString);    
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();    
            conn.setDoOutput(true);    
            conn.setRequestMethod("POST");    
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));    
            String line;    
           while ((line = in.readLine()) != null) {    
               res += line+"\n";    
         }    
            in.close();    
        } catch (Exception e) {    
        	  ;   
        }   
        
        JSONObject jsonObject= JSONObject.fromObject(res);
        JSONObject result=(JSONObject) jsonObject.get("result");
        JSONObject addressComponent= (JSONObject) result.get("addressComponent");
        if(addressComponent==null){
        	  return null;
        }
        //String country=(String) addressComponent.get("country");
        String province=(String) addressComponent.get("province");
        String city=(String) addressComponent.get("city");
        String district=(String) addressComponent.get("district");
        String[] areaArray= new String[]{province,city,district};
        
       // "province":"西藏自治区","city":"阿里地区","district":"改则县"
       // System.out.println(res);  
        return areaArray;    
}
	
}


