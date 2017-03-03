package com.example.yls.ad0302_json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn_zuozhuang;
    private Button btn_jiexi;
    private Button btn_gson;
    private TextView tv_json;
    final ArrayList<Student> arrList = new ArrayList<Student>();
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();


    }

    private void initViews() {
        tv_json = (TextView) findViewById(R.id.tv_json);
        btn_zuozhuang = (Button) findViewById(R.id.btn_zuozhuang);
        btn_jiexi = (Button) findViewById(R.id.btn_jiexi);
        btn_gson = (Button) findViewById(R.id.btn_gson);
        Student s2 = new Student(002, "a", 20);
        Student s3 = new Student(003, "b", 21);
        Student s4 = new Student(004, "c", 22);
        arrList.add(s2);
        arrList.add(s3);
        arrList.add(s4);

        btn_zuozhuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONArray array = new JSONArray();
                final JSONObject stuObj = new JSONObject();
                for (int i = 0; i < arrList.size(); i++) {
                    JSONObject obj = new JSONObject();
                    try {
                        obj.put("id", arrList.get(i).getId());
                        obj.put("name", arrList.get(i).getName());
                        obj.put("age", arrList.get(i).getAge());
                        array.put(obj);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                try {
                    stuObj.put("stulist", array);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.e(TAG, "onClick: " + stuObj.toString());
                tv_json.setText(stuObj.toString());
            }
        });

        btn_jiexi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Student> stuList = new ArrayList<Student>();
                JSONArray array = new JSONArray();
                final JSONObject stuObj = new JSONObject();
                for (int i = 0; i < arrList.size(); i++) {
                    JSONObject obj = new JSONObject();
                    try {
                        obj.put("id", arrList.get(i).getId());
                        obj.put("name", arrList.get(i).getName());
                        obj.put("age", arrList.get(i).getAge());
                        array.put(obj);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                try {
                    stuObj.put("stulist", array);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    JSONObject obj = new JSONObject(stuObj.toString());
                    JSONArray jsonArray = obj.getJSONArray("stulist");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject sObj = jsonArray.getJSONObject(i);
                        int id = sObj.getInt("id");
                        String name = sObj.getString("name");
                        int age = sObj.getInt("age");
                        Student s = new Student(id, name, age);
                        //  Log.d(TAG, "onClick: " + s.getId() +"   " +s.getName() +"   "+ s.getAge());
                        //Toast.makeText(MainActivity.this, s.getId() + s.getName(), Toast.LENGTH_SHORT).show();
                        stuList.add(s);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                tv_json.setText(stuList.get(2).getId() + "   " + stuList.get(2).getName() + "   " + stuList.get(2).getAge());

            }
        });

        btn_gson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jsonStr = "{\"id\":20,\"name\":\"a\",\"age\":2}";
                Student s;
                Gson gson = new Gson();
              s   =  gson.fromJson(jsonStr,Student.class);
                tv_json.setText(s.getId() + "  " + s.getName() + "    " + s.getAge());

            }
        });
    }

    private JSONObject getStuJsonObj() {
        JSONObject obj = new JSONObject();

        Student s1 = new Student(001, "a", 20);

        try {
            obj.put("id", s1.getId());
            obj.put("name", s1.getName());
            obj.put("age", s1.getAge());
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return obj;
    }
}
