package com.example.dell.app_doctor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

public class hell_doctor extends AppCompatActivity {
    String a0,a2,a1,h1,d_id;
    String right[]=new String[7];
    String left[]=new String[7];
    String day[]=new String[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hell_doctor);
        SharedPreferences test_name = getSharedPreferences("NAME", 0);
         h1=test_name.getString("name", "").toString();





    }

    public void doh1(View view) {

   RequestQueue rq = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.GET,"http://192.168.43.108/hassan/doctor1.php?d_name="+h1,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        JSONArray jsonArray = null;
                        try {
                            jsonArray = new JSONArray(s);

                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                d_id= jsonObject.getString("d_id");

                                right[i]= jsonObject.getString("d_timeofwork");
                                left[i]= jsonObject.getString("d_timeofwork1");
                                day[i]=jsonObject.getString("d_dayofwork");
                            }


                                Intent go = new Intent(hell_doctor.this, modf.class);

                            go.putExtra("d_id", d_id);
                            go.putExtra("time_right", right);
                            go.putExtra("time_left", left);
                            go.putExtra("d_dayofwork",day);
                                startActivity(go);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Toast.makeText(hell_doctor.this,"الخادم غير متصل", Toast.LENGTH_LONG).show();

            }
        });
        rq.add(sr);

    }
    public void yo1(View view) {


        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);

    }
}