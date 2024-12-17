package com.example.kiddosafecard;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class User2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item2);
    }
    String vaccineName , Date , Time , remarks ;
    public User2(){ }
    public User2(String vaccineName, String Date, String Time,String remarks) {
        this.vaccineName = vaccineName;
        this.Date = Date;
        this.Time = Time;
        this.remarks = remarks;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
