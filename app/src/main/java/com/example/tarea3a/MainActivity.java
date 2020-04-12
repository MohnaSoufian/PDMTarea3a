package com.example.tarea3a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String Tag= "prueba";
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
                startActivityForResult(startIntent, 1234);
            }

        });
        // BUTTON para hacer un intento implicito a la segunda actividad
        final Button implicitIntentBtn = (Button) findViewById(R.id.implicitIntentBtn);
        implicitIntentBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent startImplicitIntent= new Intent("soufian.PRUEBA" );
                startImplicitIntent.putExtra("ExtraNumber", 3);
                startActivityForResult(startImplicitIntent, 1234);
            }

        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intentRespuesta) {
        super.onActivityResult(requestCode, resultCode, intentRespuesta);
        TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
        if (requestCode == 1234) {
            Log.d(Tag, "request code es correcto");
            int respuesta = intentRespuesta.getExtras().getInt("resultado");
            Log.d(Tag, respuesta+"");
            resultTextView.setText(respuesta+"");

            // Ahora compartir el resultado
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, respuesta+"");
            sendIntent.setType("text/plain");
            Log.d(Tag, "Starting Activity");
            startActivity(sendIntent);
        }
    } // ()
}
