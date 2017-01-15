package com.example.jota.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    private int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText)findViewById(R.id.nombre);
    }


    public void abrirActivity(View v){
        Intent i = new Intent(this,Main2Activity.class);
        i.putExtra("nombre",nombre.getText().toString());
        startActivityForResult(i,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                Toast.makeText(getBaseContext(),"Bienvenido " + data.getExtras().getString("RESULTADO"),Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getBaseContext(),"Introduzca su verdadero nombre",Toast.LENGTH_LONG).show();
            }
        }
    }
}
