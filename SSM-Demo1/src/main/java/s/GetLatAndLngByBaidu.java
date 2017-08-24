package s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * ��ȡ��γ��
 *
 * @author jueyue ���ظ�ʽ��Map<String,Object> map map.put("status",
 * reader.nextString());//״̬ map.put("result", list);//��ѯ���
 * list<map<String,String>>
 * ��Կ:C0a9eecc5b366bde41202sljdflsjfsldjf   ��Ҫ�Լ�ȥ����
 * Created by hellcat on 2016/7/27.
 */
public class GetLatAndLngByBaidu {

    public static Map<String,Double> getLngAndLat(String address){
        Map<String,Double> map=new HashMap<String, Double>();
        String url = "http://api.map.baidu.com/geocoder/v2/?address="+address+"&output=json&ak=C0a9eecc5b366bde41202sljdflsjfsldjf";
        try {
            String json = loadJSON(url);
            JSONObject obj = JSONObject.fromObject(json);
            if(obj.get("status").toString().equals("0")){
                double lng=obj.getJSONObject("result").getJSONObject("location").getDouble("lng");
                double lat=obj.getJSONObject("result").getJSONObject("location").getDouble("lat");
                map.put("lng", getDecimal(lng));
                map.put("lat", getDecimal(lat));
                //System.out.println("���ȣ�"+lng+"---γ�ȣ�"+lat);
            }else{
              //  LogUtil.debug("δ�ҵ���ƥ��ľ�γ�ȣ�");
                //System.out.println("δ�ҵ���ƥ��ľ�γ�ȣ�");
            }
        }catch (Exception e){
           // LogUtil.error("δ�ҵ���ƥ��ľ�γ�ȣ������ַ");
        }
        return map;
    }

    public static double getDecimal(double num) {
        if (Double.isNaN(num)) {
            return 0;
        }
        BigDecimal bd = new BigDecimal(num);
        num = bd.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
        return num;
    }

    public static String loadJSON (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream(),"UTF-8"));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return json.toString();
    }
}