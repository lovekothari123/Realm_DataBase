package com.example.stegowl.demosdp;


import android.app.ActivityManager;
import android.content.Intent;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


public class MainActivity extends AppCompatActivity {
    Realm realm;
    EditText name,age,email,phoneno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addview);
        name = (EditText)findViewById(R.id.name);
        age = (EditText)findViewById(R.id.age);
        email= (EditText)findViewById(R.id.email);
        phoneno = (EditText)findViewById(R.id.phoneno);
        Realm.init(this);

        realm = Realm.getDefaultInstance();



        //TODO migration

        //TODO
       findViewById(R.id.addbtn).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String name_et=name.getText().toString();
               String  age_et=age.getText().toString();
               String email_et=email.getText().toString();
               String phone_no=phoneno.getText().toString();
               if(name_et.isEmpty()){
                   name.setError("Please enter name ");
               } else
                   if(age_et.isEmpty()){
                       age.setError("please enter age ");
                   }else
                       if(email_et.isEmpty()){
                           email.setError("please enter email");
                       }else
                           if(phone_no.isEmpty()){
                               phoneno.setError("please enter phone no");
                           }else{
                               realm.beginTransaction();  //open the database
                               PersonDetailsModel obj=realm.createObject(PersonDetailsModel.class );
                               obj.setName(name_et.toString());
                               obj.setEmail(email_et.toString());
                               obj.setPhoneno(phone_no.toLowerCase());
                               obj.setAge(age_et.toString());

                               realm.commitTransaction();
                              Intent gotonew=new Intent(MainActivity.this,ShowView.class);
                               startActivity(gotonew);
                               finish();

                           }

           }
       });
    }
}
