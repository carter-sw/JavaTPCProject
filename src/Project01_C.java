import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class Project01_C {
    public static void main(String[] args) {
        String src = "info.json";
        //IO -> Stream (스트림)
        InputStream is = Project01_C.class.getResourceAsStream(src);

        if(is == null){
            throw new NullPointerException("Can not find resource file.");
        }

        JSONTokener tokener = new JSONTokener(is);
        JSONObject obj = new JSONObject(tokener);
        JSONArray students = obj.getJSONArray("students");

        for(int i=0; i<students.length(); i++){
            JSONObject student =(JSONObject) students.get(i);
            System.out.print(student.get("name")+"\t");
            System.out.print(student.get("address")+"\t");
            System.out.println(student.get("phone")+"\t");
        }

    }
}

