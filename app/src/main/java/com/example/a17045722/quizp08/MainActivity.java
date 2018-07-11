package com.example.a17045722.quizp08;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvAge;
    EditText etName;
    EditText etAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.TVNAME);
        tvAge = findViewById(R.id.TVAGE);
        etName = findViewById(R.id.ETNAME);
        etAge = findViewById(R.id.ETAGE);


    }

    @Override
    protected void onPause(){
        super.onPause();

        String strName=etName.getText().toString();
        String age=etAge.getText().toString();

        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit= prefs.edit();

        prefEdit.putString("name",strName);
        if(age.isEmpty()){
            prefEdit.putInt("age",0);
        }
        else{
            prefEdit.putInt("age",Integer.parseInt(age));
        }

        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String strName=prefs.getString("name","");
        int age = prefs.getInt("age",0);


        etName.setText(strName);
        if(age==0){
            etAge.setText("");
        }else {
            etAge.setText(age+"");
        }


    }

}