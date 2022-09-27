package com.example.jugandoconapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import  android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String NOMBRE = "NOMBRE" ;
    private static final int CODIGO_IDENTIFICACION_SALUDO = 10;
    private static final int CODIGO_IDENTIFICACION_COLOR = 5;
    Button btnLanzar, btnColor;
    EditText editTextNombre;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CODIGO_IDENTIFICACION_SALUDO && resultCode == RESULT_OK)
        {
            String numero = data.getStringExtra(SaludoActivity.NUMERO);
            editTextNombre.setText(editTextNombre.getText() + " " + numero);
        }
        if(requestCode == CODIGO_IDENTIFICACION_COLOR && resultCode == RESULT_OK)
        {
            String numero = data.getStringExtra(Color.COLOR);
            editTextNombre.setText(editTextNombre.getText() + " " + numero);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLanzar = findViewById(R.id.btnLanzar);
        editTextNombre = findViewById(R.id.editTextNombre);
        btnColor = findViewById(R.id.btnColor);

        btnLanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, SaludoActivity.class);
                intento.putExtra(NOMBRE,editTextNombre.getText().toString());
                //startActivity(intento);//Lanza la Actividad

                startActivityForResult(intento,CODIGO_IDENTIFICACION_SALUDO);
            }
        });

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(MainActivity.this, Color.class);
                intento.putExtra(NOMBRE,editTextNombre.getText().toString());

                startActivityForResult(intento,CODIGO_IDENTIFICACION_COLOR);
            }
        });
    }
}