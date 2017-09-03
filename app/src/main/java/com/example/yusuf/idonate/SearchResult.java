package com.example.yusuf.idonate;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchResult extends AppCompatActivity {
    ListView lv;
    private List<user> users = new ArrayList<user>();
    CustomListAdapter adapter;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        lv=(ListView)findViewById(R.id.resultList);
        Intent i=getIntent();
        String bType=i.getStringExtra("bType");
        adapter=new CustomListAdapter(this,users);
        lv.setAdapter(adapter);
        pDialog = new ProgressDialog(this);
        // Showing progress dialog
        pDialog.setMessage("Loading...");
        pDialog.show();

        BackendlessDataQuery dataQuery = new BackendlessDataQuery();
        dataQuery.setWhereClause( "userType = 'donor' and blood ='"+bType+"'" );



        Backendless.Data.of( user.class ).find( dataQuery, new AsyncCallback<BackendlessCollection<user>>()
        {
            @Override
            public void handleResponse( BackendlessCollection<user> nycPeople )
            {




                Iterator<user> iterator = nycPeople.getCurrentPage().iterator();

                while( iterator.hasNext() )
                {
                    user person = iterator.next();

                    users.add(person);

                    adapter.notifyDataSetChanged();

                }
                pDialog.dismiss();
            }

            @Override
            public void handleFault( BackendlessFault backendlessFault )
            {
                Toast.makeText(getApplicationContext(),backendlessFault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } );







    }
}
