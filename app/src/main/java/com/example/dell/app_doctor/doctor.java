package com.example.dell.app_doctor;


public class doctor {
    String teket,name,day,time;
    public doctor(String teket,String name,String day,String time){
        this.teket=teket;
        this.name=name;
        this.day=day;
        this.time=time;
    }

    public String getteket() {
        return teket;
    }

    public void setTeket(String teket) {
        this.teket = teket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

