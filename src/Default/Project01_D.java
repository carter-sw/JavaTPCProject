package Default;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Project01_D {
    public static void main(String[] args) {
        // String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=";
        String client_id ="2ol0grbpbo"; // Naver cloud 지도 API 발급 ID
        String client_secret="7kH85K88PydJmNpqZil6damqvR2tT6Aj6Lu6kzVa"; // Naver cloud 지도 API 발급 P/W
        BufferedReader io = new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.println("주소를 입력하세요.");
            String address = io.readLine();
            String addr = URLEncoder.encode(address,"UTF-8"  );
            String reqUrl = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="+addr;

            URL url = new URL(reqUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID",client_id);
            con.setRequestProperty("X-NCP-APIGW-API-KEY",client_secret);

            BufferedReader br;

            int responseCode = con.getResponseCode(); // 200ok 확인하는 절차

            if(responseCode == 200){
                br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
            }else{
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));

            }

            String line;
            StringBuffer reponse = new StringBuffer();
            while ((line= br.readLine())!=null){
                reponse.append(line);
            }
            br.close();

            JSONTokener tokener = new JSONTokener(reponse.toString());
            JSONObject object = new JSONObject(tokener);
            System.out.println(object.toString());

            JSONArray arr = object.getJSONArray("addresses");
            for(int i=0; i<arr.length(); i++){
                JSONObject temp = (JSONObject) arr.get(i);
                System.out.println("address: "+temp.get("roadAddress"));
                System.out.println("jibunAddress: "+temp.get("jibunAddress"));
                System.out.println("경도: "+temp.get("x"));
                System.out.println("위도: "+temp.get("y"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
