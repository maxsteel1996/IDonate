package com.example.yusuf.idonate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.backendless.Backendless;

public class MainMenu extends AppCompatActivity {

    public static final String APP_ID="6C61EAE8-EA2A-1F75-FF0B-B56282D72300";
    public static final String SECRET_KEY="C6CC42C3-0ADE-9D59-FF0D-449D4F734F00";
    public static final String VIRSION="v1";


    public void bloodBank(View v){
        startActivity(new Intent(MainMenu.this,BloodBank.class));
    }







    public void peopleInNeed(View view){
        startActivity(new Intent(MainMenu.this,PeopleInNeed.class));
    }

    public void search(View v){
        startActivity(new Intent(MainMenu.this,SearchBlood.class));
    }

    public void add_member(View v){
        startActivity(new Intent(MainMenu.this,AddMember.class));
    }
    public void post_req(View v){
        startActivity(new Intent(MainMenu.this,PostRequest.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        Backendless.initApp(this,APP_ID,SECRET_KEY,VIRSION);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
