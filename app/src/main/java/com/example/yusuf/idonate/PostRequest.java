package com.example.yusuf.idonate;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.HashMap;
import java.util.Map;

public class PostRequest extends AppCompatActivity {
    EditText name,phone,email,age,city,pin;
    Spinner btype;
    Button req;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    String[] bloods={"AB+","A+","A-","O+","O-","AB-","B+","B-"};
    Boolean mal;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_form);
        radioSexGroup=(RadioGroup)findViewById(R.id.rsex);


        req=(Button)findViewById(R.id.rpost) ;
        name=(EditText)findViewById(R.id.rname);
        phone=(EditText)findViewById(R.id.rphone);
        email=(EditText)findViewById(R.id.remail);
        age=(EditText)findViewById(R.id.rage);
        city=(EditText)findViewById(R.id.rcity);
        pin=(EditText)findViewById(R.id.rpin);
        btype=(Spinner)findViewById(R.id.rblood);

        ArrayAdapter arrayAdapter=new ArrayAdapter(PostRequest.this, android.R.layout.simple_dropdown_item_1line, bloods);
        btype.setAdapter(arrayAdapter);

        int selectedId=radioSexGroup.getCheckedRadioButtonId();
        radioSexButton=(RadioButton)findViewById(selectedId);

        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pDialog = new ProgressDialog(PostRequest.this);
                // Showing progress dialog
                pDialog.setMessage("Submitting.....");
                pDialog.show();
                HashMap contact = new HashMap();
                contact.put( "name", name.getText().toString() );
                contact.put( "age", age.getText().toString() );
                contact.put( "phone", phone.getText().toString() );
                contact.put( "email", email.getText().toString() );
                contact.put( "phone", phone.getText().toString() );

                int selectedId=radioSexGroup.getCheckedRadioButtonId();
                radioSexButton=(RadioButton)findViewById(selectedId);

                if(radioSexButton.getText().toString().equals("Male")){
                    mal=true;
                }else{
                    mal=false;
                }

                contact.put( "male",mal  );
                contact.put( "city", city.getText().toString() );
                contact.put( "pin", pin.getText().toString() );
                contact.put( "blood", btype.getSelectedItem().toString() );
                contact.put( "userType", "requester" );
                // save object asynchronously

                Backendless.Persistence.of( "user" ).save( contact, new AsyncCallback<Map>() {
                    public void handleResponse( Map response )
                    {
                        // new Contact instance has been saved
                        pDialog.dismiss();
                        Toast.makeText(getApplicationContext(),"Successfully posted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(PostRequest.this,MainMenu.class));
                    }

                    public void handleFault( BackendlessFault fault )
                    {
                        // an error has occurred, the error code can be retrieved with fault.getCode()
                        Toast.makeText(getApplicationContext(),fault.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}
