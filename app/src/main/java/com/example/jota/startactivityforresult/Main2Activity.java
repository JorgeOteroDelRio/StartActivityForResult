package com.example.jota.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("nombre");
        View fragment = findViewById(R.id.fragment_confirmacion);
        TextView confirmacion_txt = (TextView) fragment.findViewById(R.id.confirmacion);
        confirmacion_txt.setText("Tu nombre es " + nombre + ", es correcto?");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                Toast.makeText(getBaseContext(),"Bienvenido " + nombre,Toast.LENGTH_LONG);
            }else{
                Toast.makeText(getBaseContext(),"Introduzca su verdadero nombre",Toast.LENGTH_LONG);
            }
        }
    }


    public void aceptar_btn(View v){
        setResult(RESULT_OK);
    }

    public void cancelar_btn(View v){
        setResult(RESULT_CANCELED);
    }
}
