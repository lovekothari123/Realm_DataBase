package com.example.stegowl.demosdp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Stegowl on 20-01-2018.
 */

public class ShowView extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showview);
        TextView show = (TextView)findViewById(R.id.show);
        Realm.init(this);
        Realm realm = Realm.getDefaultInstance(); //creating  database oject
        RealmResults<PersonDetailsModel> results=realm.where(PersonDetailsModel.class).findAllAsync();
        results.load();
        String output="";
        for(PersonDetailsModel pm:results){
            output+=pm.toString();
           String name=pm.getName();
           Log.d("nameaya",name);
            String phone=pm.getAge();
            Log.d("phoneaya",phone);
        }
        show.setText(output );
    }
}
