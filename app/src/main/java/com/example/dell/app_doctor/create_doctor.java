package com.example.dell.app_doctor;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class create_doctor extends AppCompatActivity {
    EditText d_id;
    EditText d_username;
    EditText d_password;
    EditText d_password1;
    EditText d_balans;
    EditText r1,r2,r3,r4,r5,r6;
    EditText l1,l2,l3,l4,l5,l6;
    String str,str1,str2,str3,str4,str5;
    int d_flig=0;
    int d_mark=0;
    String uu,uuu;
    Button ins;
    CheckBox b,b1,b2,b3,b4,b5;


    ProgressDialog dialog = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_doctor);
        d_id = (EditText) findViewById(R.id.d1);
        d_username = (EditText) findViewById(R.id.d2);




        d_password = (EditText) findViewById(R.id.d3);
        d_password1= (EditText) findViewById(R.id.d9);
        d_balans = (EditText) findViewById(R.id.p7);

        b=(CheckBox) findViewById(R.id.sat);
        b1=(CheckBox) findViewById(R.id.sat1);
        b2=(CheckBox) findViewById(R.id.sat2);
        b3=(CheckBox) findViewById(R.id.sat3);
        b4=(CheckBox) findViewById(R.id.sat4);
        b5=(CheckBox) findViewById(R.id.sat5);

/////////////////////////////////////////
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


////////////////////////////////////





///////////////////////right//////////////////

        r1 = (EditText) findViewById(R.id.m1);
        r2 = (EditText) findViewById(R.id.m2);
        r3 = (EditText) findViewById(R.id.m3);
        r4 = (EditText) findViewById(R.id.m4);
        r5= (EditText) findViewById(R.id.m5);
        r6 = (EditText) findViewById(R.id.m6);


///////////////////////left//////////////////

        l1 = (EditText) findViewById(R.id.y1);
        l2= (EditText) findViewById(R.id.y2);
        l3 = (EditText) findViewById(R.id.y3);
        l4 = (EditText) findViewById(R.id.y4);
        l5 = (EditText) findViewById(R.id.y5);
        l6 = (EditText) findViewById(R.id.y6);

        ins = (Button) findViewById(R.id.d4);
    }

    public void but20(View view) {
        /////////////////////////Check fields/////////
        if (d_id.length()<1){
            //d_id.setBackgroundColor(Color.parseColor("#FFFF1A0C"));
            Toast.makeText(create_doctor.this,"الرجاء ادخال الرقم التعريفي",Toast.LENGTH_LONG).show();

            return;

        }
        if (d_username.length()==0){
            //d_username.setBackgroundColor(Color.parseColor("#FFFF1A0C"));
            Toast.makeText(create_doctor.this,"الرجاء أدخال اسم المستخدم",Toast.LENGTH_LONG).show();
            return;
        }
        if (d_username.length()<4){
            //d_username.setBackgroundColor(Color.parseColor("#FFFF1A0C"));
            Toast.makeText(create_doctor.this,"اسم المستخدم قصير",Toast.LENGTH_LONG).show();
            return;
        }
        if (d_password.length()==0){
            //d_password.setBackgroundColor(Color.parseColor("#FFFF1A0C"));
            Toast.makeText(create_doctor.this,"الرجاء أدخال كلمة المرور",Toast.LENGTH_LONG).show();
            return;
        }
        if (d_password.length()<4){
            //d_password.setBackgroundColor(Color.parseColor("#FFFF1A0C"));
            Toast.makeText(create_doctor.this,"كلمة المرور قصيرة",Toast.LENGTH_LONG).show();
            return;
        }
        if(!((d_password.getText().toString()).equals(d_password1.getText().toString()))) {
            //d_password1.setBackgroundColor(Color.parseColor("#FFFF1A0C"));
            //d_password.setBackgroundColor(Color.parseColor("#FFFF1A0C"));
            Toast.makeText(create_doctor.this,"كلمة المرور غير مطابقة",Toast.LENGTH_LONG).show();
            return;
        }

        /*if (d_balans.length()!=1){
            //d_phone.setBackgroundColor(Color.parseColor("#FFFF1A0C"));
            Toast.makeText(create_doctor.this,"قيمة المقابلة قليلة",Toast.LENGTH_LONG).show();
            return;
        }*/





////////////////////////add in database////////////




        dialog = ProgressDialog.show(create_doctor.this, "", "اضافة مستخدم جديد", true);

        RequestQueue rq = Volley.newRequestQueue(this);

        StringRequest sr = new StringRequest(Request.Method.GET,"http://192.168.43.108/hassan/uu.php? d_id="+d_id.getText().toString()+"&d_username=" + d_username.getText().toString() + "&d_password=" + d_password.getText().toString() + "&d_balans=" + d_balans.getText().toString()+ "&d_flig=" + d_flig+"&d_mark=" + d_mark,


                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Toast.makeText(create_doctor.this, s, Toast.LENGTH_LONG).show();
                        dialog.cancel();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Toast.makeText(create_doctor.this, "الخادم غير متصل", Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });


        RequestQueue rq1 = Volley.newRequestQueue(this);
        StringRequest sr1 = new StringRequest(Request.Method.GET,"http://192.168.43.108/hassan/h50.php? d_id="+d_id.getText().toString()+ "&d_dayofwork=" + str+ "&d_dayofwork1=" +  str1 +"&d_dayofwork2=" + str2  + "&d_dayofwork3=" + str3+ "&d_dayofwork4=" + str4 +"&d_dayofwork5=" + str5 +"&t_r1=" +r1.getText().toString()+"&t_r2=" +r2.getText().toString()+"&t_r3=" +r3.getText().toString()+"&t_r4=" +r4.getText().toString()+"&t_r5=" +r5.getText().toString()+"&t_r6=" +r6.getText().toString()+"&t_l1=" +l1.getText().toString()+"&t_l2" +l2.getText().toString()+"&t_l3=" +l3.getText().toString()+"&t_l4=" +l4.getText().toString()+"&t_l5=" +l5.getText().toString()+"&t_l6=" +l6.getText().toString(),


                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Toast.makeText(create_doctor.this, s, Toast.LENGTH_LONG).show();
                        dialog.cancel();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Toast.makeText(create_doctor.this, "الخادم غير متصل", Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });


        rq.add(sr);
        rq1.add(sr1);


    }


}
