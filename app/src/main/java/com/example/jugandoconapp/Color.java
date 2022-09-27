package com.example.jugandoconapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Color extends AppCompatActivity {
    public static final String COLOR = "AZUL";
    TextView textView, editTextTextPersonName;
Button btnVolverColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        textView = findViewById(R.id.textView);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        btnVolverColor = findViewById(R.id.btnVolverColor);

        Intent intento = new Intent();
        String nombre = intento.getStringExtra(MainActivity.NOMBRE);

        textView.setText("Hola " + nombre);

        btnVolverColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String color = editTextTextPersonName.getText().toString();

                Intent intento = new Intent();
                intento.putExtra(COLOR,color);

                setResult(RESULT_OK,intento);
                finish();
            }
        });
    }
}