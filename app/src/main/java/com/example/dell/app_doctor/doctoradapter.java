package com.example.dell.app_doctor;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;



public class doctoradapter extends RecyclerView.Adapter<doctoradapter.MyViewHolder> {

    private List<doctor> doctorlist = new ArrayList<>();
    private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,teket,day,time;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.textView);
            teket = (TextView) view.findViewById(R.id.textView2);
            day = (TextView) view.findViewById(R.id.textView6);
            time = (TextView) view.findViewById(R.id.textView8);

        }
    }


    public doctoradapter(List<doctor> doctorlist) {
        this.doctorlist = doctorlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.activity_find, parent, false);
        context=itemView.getContext();
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final doctor doctor = doctorlist.get(position);
        holder.name.setText(doctor.getName());
        holder.teket.setText(doctor.getteket());
        holder.day.setText(doctor.getDay());
        holder.time.setText(doctor.getTime());


    }

    @Override
    public int getItemCount() {
        return doctorlist.size();
    }
}