package com.example.tarea3a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    public static final String Tag= "prueba";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(Tag ,"segunda actividad onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        final Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText numEditText= findViewById(R.id.numEditText);
                if(getIntent().hasExtra("ExtraNumber")){
                    Log.d(Tag,"Extra has value");
                    int number1= getIntent().getExtras().getInt("ExtraNumber");
                    int number2= Integer.parseInt(numEditText.getText().toString());
                    int result= number1+number2;
                    Log.d(Tag, result+"");
                }
            }
        });

    }
}
