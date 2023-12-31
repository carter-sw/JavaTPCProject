package Default;

import org.json.JSONArray;
import org.json.JSONObject;

public class Project01_B {
    public static void main(String[] args) {
        //JSON -Java(org.json)
        JSONArray students = new JSONArray();

        JSONObject student = new JSONObject();
        student.put("name","Carter");
        student.put("phone","010-1111-1234");
        student.put("address","인천");
        System.out.println(student); //{"address":"인천","phone":"010-1111-1234","name":"Carter"}

        students.put(student);

        student = new JSONObject();
        student.put("name","CARTER");
        student.put("phone","010-2222-2222");
        student.put("address","서울");

        students.put(student);

        JSONObject object = new JSONObject();
        object.put("students",students);
        System.out.println(object.toString(1));
    }
}

