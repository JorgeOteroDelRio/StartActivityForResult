package com.example.jota.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private String nombre;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        i = getIntent();
        Bundle extras = i.getExtras();
        nombre = extras.getString("nombre");
        View fragment = findViewById(R.id.fragment_confirmacion);
        TextView confirmacion_txt = (TextView) fragment.findViewById(R.id.confirmacion);
        confirmacion_txt.setText("Tu nombre es " + nombre + ", es correcto?");
    }


    public void aceptar_btn(View v){
        i.putExtra("RESULTADO",nombre);
        setResult(RESULT_OK, i);
        finish();
    }

    public void cancelar_btn(View v){
        setResult(RESULT_CANCELED);
        finish();
    }
}
