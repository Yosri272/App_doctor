package com.example.dell.app_doctor;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class login_doctor extends AppCompatActivity {
    EditText d_username, d_password;
    Button log;
    ProgressDialog dialog = null;
    final Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_doctor);
        d_username = (EditText) findViewById(R.id.user);
        d_password = (EditText) findViewById(R.id.pass);
        log =(Button)findViewById(R.id.login);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.add_doctor:
                Intent j = new Intent(this, phone.class);
                startActivity(j);
                return true;


            //////////
            case R.id.ex:

                AlertDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void but17(View view) {
        /////////////////1////////////////////
        SharedPreferences test_name = getSharedPreferences("NAME", 0);
        SharedPreferences.Editor editor = test_name.edit();
        editor.putString("name", d_username.getText().toString() );
        editor.commit();
        ////////////////////////2///////////
        SharedPreferences test_name1 = getSharedPreferences("NAME", 0);
        SharedPreferences.Editor editor1 = test_name.edit();
        editor1.putString("d_username", d_username.getText().toString() );
        editor1.commit();

        ///////check fields///////
        if (d_username.length()==0){
            Toast.makeText(login_doctor.this,"الرجاء ادخال أسم المستخدم",Toast.LENGTH_LONG).show();
            return;
        }
        if (d_password.length()==0){
            Toast.makeText(login_doctor.this,"الرجاء ادخال كلمة المرور",Toast.LENGTH_LONG).show();
            return;
        }

///////////////////////////////////////////check in database/////////////
        dialog = ProgressDialog.show(login_doctor.this, "", "تسجيل دخول", true);


        RequestQueue rq = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.GET,"http://192.168.43.108/hassan/d_sync.php?d_username="+d_username.getText().toString()+"&d_password="+d_password.getText().toString(),

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        dialog.cancel();
                        if(s.matches("login")){
                            Intent go = new Intent(login_doctor.this,hell_doctor.class);
                            startActivity(go);
                        }
                        else{
                            Toast.makeText(login_doctor.this, "هنالك خطأ في اسم المستخدم او كلمة المرور", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                Toast.makeText(login_doctor.this, "الخادم غير متصل", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        rq.add(sr);


    }
    public void AlertDialog() {


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        alertDialogBuilder
                .setMessage("هل تود الخروج!!!")
                .setCancelable(false)
                .setPositiveButton("نعم",new DialogInterface.OnClickListener()
                {

                    public void onClick(DialogInterface dialog,int id) {
                        System.exit(0);

                    }
                })
                .setNegativeButton("لا",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id)
                    {

                        dialog.cancel();

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();


//////////////////////

//////////////////////
}
    }
