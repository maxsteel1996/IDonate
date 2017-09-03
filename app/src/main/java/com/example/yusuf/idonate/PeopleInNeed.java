package com.example.yusuf.idonate;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class PeopleInNeed extends AppCompatActivity {
    ListView lv;
    private List<user> users = new ArrayList<user>();
    DonorAdapter adapter;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_in_need);
        lv=(ListView)findViewById(R.id.listView1);
        adapter=new DonorAdapter(this,users);
        lv.setAdapter(adapter);
        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

//
//        Backendless.Data.mapTableToClass( "user", user.class );
//        Backendless.Persistence.of(user.class).find(new AsyncCallback<BackendlessCollection<user>>() {
//            @Override
//            public void handleResponse(BackendlessCollection<user> foundContacts) {
//
//
//                List<user> code=foundContacts.getData();
//
//                for(user a:code){
//                    users.add(a);
//                    Toast.makeText(getApplicationContext(),a.getName(), Toast.LENGTH_SHORT).show();
//                }
//                adapter.notifyDataSetChanged();
//                pDialog.dismiss();
//
//            }
//
//            @Override
//            public void handleFault(BackendlessFault fault) {
//                //Snackbar.make(coordinatorLayout,"Network error, check your internet connection",Snackbar.LENGTH_LONG).show();
//
//
//            }
//        });
//




        BackendlessDataQuery dataQuery = new BackendlessDataQuery();
        dataQuery.setWhereClause( "userType = 'requester'" );



        Backendless.Data.of( user.class ).find( dataQuery, new AsyncCallback<BackendlessCollection<user>>()
        {
            @Override
            public void handleResponse( BackendlessCollection<user> nycPeople )
            {
                Iterator<user> iterator = nycPeople.getCurrentPage().iterator();
//                pDialog.dismiss();

                while( iterator.hasNext() )
                {
                    user person = iterator.next();

                    users.add(person);

                    adapter.notifyDataSetChanged();
              pDialog.dismiss();
                }
            }

            @Override
            public void handleFault( BackendlessFault backendlessFault )
            {
                pDialog.dismiss();
                Toast.makeText(getApplicationContext(),backendlessFault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } );






    }
}
