package com.example.dell.app_doctor;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class modf extends AppCompatActivity {
    String h1,d_id;
    String right[]=new String[7];
    String left[]=new String[7];
    String day[]=new String[7];
    String str,str1,str2,str3,str4,str5;
    EditText r1,r2,r3,r4,r5,r6;
    EditText l1,l2,l3,l4,l5,l6;
    CheckBox b,b1,b2,b3,b4,b5;
    ProgressDialog dialog = null;

String ff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modf);



/////////////////CheckBox////////////

        b=(CheckBox) findViewById(R.id.s1);
        b1=(CheckBox) findViewById(R.id.s2);
        b2=(CheckBox) findViewById(R.id.s3);
        b3=(CheckBox) findViewById(R.id.s4);
        b4=(CheckBox) findViewById(R.id.s5);
        b5=(CheckBox) findViewById(R.id.s6);



        ///////////////////////right//////////////////

        r1 = (EditText) findViewById(R.id.m1);
        r2 = (EditText) findViewById(R.id.m2);
        r3 = (EditText) findViewById(R.id.m3);
        r4 = (EditText) findViewById(R.id.m4);
        r5 = (EditText) findViewById(R.id.m5);
        r6 = (EditText) findViewById(R.id.m6);

        ///////////////////////left//////////////////

        l1 = (EditText) findViewById(R.id.y1);
        l2 = (EditText) findViewById(R.id.y2);
        l3 = (EditText) findViewById(R.id.y3);
        l4 = (EditText) findViewById(R.id.y4);
        l5 = (EditText) findViewById(R.id.y5);
        l6 = (EditText) findViewById(R.id.y6);

        /////////////////putExtra//////////////////
        d_id = getIntent().getExtras().getString("d_id",d_id);
        right = getIntent().getExtras().getStringArray("time_right");
        left = getIntent().getExtras().getStringArray("time_left");
        day = getIntent().getExtras().getStringArray("d_dayofwork");


/* ff=day[0];
      //  if(!(ff.isEmpty()))
       b.setChecked(true);
     //   else
            b.setChecked(false);
       b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });*/


        ///////////////////////////////////time in textfeld///////////////////////////////////////
        r1.setText(right[0]);
        l1.setText(left[0]);
        r2.setText(right[1]);
        l2.setText(left[1]);
        r3.setText(right[2]);
        l3.setText(left[2]);
        r4.setText(right[3]);
        l4.setText(left[3]);
        r5.setText(right[4]);
        l5.setText(left[4]);
        r6.setText(right[5]);
        l6.setText(left[5]);

        ///////////////////////////chechbox////////////////////////////

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b.isChecked()==true) {
                    str="السبت";

                }
                else
                    str="";
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b1.isChecked()==true) {
                    str1="الاحد";

                }
                else
                    str1="";
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b2.isChecked()==true) {
                    str2="الاثنين";

                }
                else
                    str2="";
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b3.isChecked()==true) {
                    str3="الثلاثاء";

                }
                else
                    str3="";
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b4.isChecked()==true) {
                    str4="الاربعاء";

                }
                else
                    str4="";
            }
        });


        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b5.isChecked()==true) {
                    str5="الخميس";

                }
                else
                    str5="";
            }
        });




    }

    public void update(View view) {
        Toast.makeText(modf.this,d_id.toString(), Toast.LENGTH_LONG).show();


        dialog = ProgressDialog.show(modf.this, "", "اضافة مستخدم جديد", true);

        RequestQueue rq = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.GET,"http://192.168.43.108/hassan/uptime.php? d_id="+d_id.toString()+ "&d_dayofwork=" + str+ "&d_dayofwork1=" +  str1 +"&d_dayofwork2=" + str2  + "&d_dayofwork3=" + str3+ "&d_dayofwork4=" + str4 +"&d_dayofwork5=" + str5 +"&t_r1=" +r1.getText().toString()+"&t_r2=" +r2.getText().toString()+"&t_r3=" +r3.getText().toString()+"&t_r4=" +r4.getText().toString()+"&t_r5=" +r5.getText().toString()+"&t_r6=" +r6.getText().toString()+"&t_l1=" +l1.getText().toString()+"&t_l2" +l2.getText().toString()+"&t_l3=" +l3.getText().toString()+"&t_l4=" +l4.getText().toString()+"&t_l5=" +l5.getText().toString()+"&t_l6=" +l6.getText().toString(),


                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Toast.makeText(modf.this, s, Toast.LENGTH_LONG).show();
                        dialog.cancel();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Toast.makeText(modf.this, "الخادم غير متصل", Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });


        rq.add(sr);






    }
}
