package com.example.kiddosafecard;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
    }
    String childName , vaccination , remarks ;
    public User(){ }
    public User(String childName, String vaccination, String remarks) {
        this.childName = childName;
        this.vaccination = vaccination;
        this.remarks = remarks;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getVaccination() {
        return vaccination;
    }

    public void setVaccination(String vaccination) {
        this.vaccination = vaccination;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
