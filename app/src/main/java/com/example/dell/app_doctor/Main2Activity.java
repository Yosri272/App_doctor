package com.example.dell.app_doctor;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    private List<doctor> doctorList = new ArrayList<>();
    private RecyclerView recyclerView;
    private doctoradapter madapter;

String h1;
    ArrayList<HashMap<String, String>> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = (RecyclerView) findViewById(R.id.recitem);

        SharedPreferences test_name = getSharedPreferences("NAME", 0);
         h1=test_name.getString("d_username", "").toString();

        madapter = new doctoradapter(doctorList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(madapter);

        showList();
    }

    protected void showList() {


        RequestQueue rq = Volley.newRequestQueue(this);
        StringRequest str = new StringRequest(Request.Method.GET, "http://192.168.43.108/hassan/text.php?d_username="+h1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        try {


                            JSONArray jsonArray = new JSONArray(s);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String a0 = jsonObject.getString("name");
                                String a2 = jsonObject.getString("teket");
                                String a3 = jsonObject.getString("day");
                                String a4 = jsonObject.getString("time");

                                doctor doctor = new doctor(a0, a2 ,a3 ,a4);
                                doctorList.add(doctor);

                            }

                            madapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Main2Activity.this, "الخادم غير متصل", Toast.LENGTH_SHORT).show();
            }
        });
        rq.add(str);

    }

}