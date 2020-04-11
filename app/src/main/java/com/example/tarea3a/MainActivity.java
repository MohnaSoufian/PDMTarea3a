package com.example.tarea3a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button segundaActividadBtn = (Button) findViewById(R.id.segundaActividadBtn);
        segundaActividadBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent startIntent= new Intent(getApplicationContext(),SecondActivity.class);
                startIntent.putExtra("ExtraNumber", 3);
                startActivity(startIntent);
            }
        });
    }
}
