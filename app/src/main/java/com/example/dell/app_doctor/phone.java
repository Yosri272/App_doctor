package com.example.dell.app_doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class phone extends AppCompatActivity {
   EditText PhoneNo;
    String a,n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        PhoneNo = (EditText) findViewById(R.id.phone);

    }

    public void phone(View view) {



        if (PhoneNo.length()!=10){
            Toast.makeText(phone.this,"رقم الهاتف غير صحيح",Toast.LENGTH_LONG).show();
            return;
        }

        RequestQueue rq = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.GET,"http://192.168.43.108/hassan/phone.php?d_phone="+PhoneNo.getText().toString(),

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        JSONArray jsonArray = null;
                        try {
                            jsonArray = new JSONArray(s);


                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            a = jsonObject.getString("d_id");
                            n = jsonObject.getString("d_name");
                            sendSMSMessage();
                            Intent i = new Intent(phone.this, create_doctor.class);

                            startActivity(i);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {


                Toast.makeText(phone.this, "الخادم غير متصل", Toast.LENGTH_LONG).show();

            }
        });
        rq.add(sr);



    }

    protected void sendSMSMessage() {
        Log.i("Send SMS", "");
        String phoneNo = PhoneNo.getText().toString();
        String message =   n.toString()+" رقمك التعريفي هو :- "+a.toString() ;


        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);

            Toast.makeText(getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "SMS faild, please try again.",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}
