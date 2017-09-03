package com.example.yusuf.idonate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SearchBlood extends AppCompatActivity {
    public void apos(View v){
        Intent intent=new Intent(getApplicationContext(),SearchResult.class);
        intent.putExtra("bType","A+");
        startActivity(intent);
    }
    public void aneg(View v){
        Intent intent=new Intent(getApplicationContext(),SearchResult.class);
        intent.putExtra("bType","A-");
        startActivity(intent);
    }
    public void bpos(View v){
        Intent intent=new Intent(getApplicationContext(),SearchResult.class);
        intent.putExtra("bType","B+");
        startActivity(intent);
    }
    public void bneg(View v){
        Intent intent=new Intent(getApplicationContext(),SearchResult.class);
        intent.putExtra("bType","B-");
        startActivity(intent);
    }
    public void abpos(View v){
        Intent intent=new Intent(getApplicationContext(),SearchResult.class);
        intent.putExtra("bType","AB+");
        startActivity(intent);
    }
    public void abneg(View v){
        Intent intent=new Intent(getApplicationContext(),SearchResult.class);
        intent.putExtra("bType","AB-");
        startActivity(intent);
    }
    public void oneg(View v){
        Intent intent=new Intent(getApplicationContext(),SearchResult.class);
        intent.putExtra("bType","O-");
        startActivity(intent);
    }
    public void opos(View v){
        Intent intent=new Intent(getApplicationContext(),SearchResult.class);
        intent.putExtra("bType","O+");
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_blood);
    }
}
