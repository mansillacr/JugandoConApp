package com.example.jugandoconapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SaludoActivity extends AppCompatActivity {
    public static final String NUMERO = "10";
    TextView saludo;
    Button btnVolver;
    EditText editTextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo2);

        saludo = findViewById(R.id.saludo);
        btnVolver = findViewById(R.id.btnVolver);
        editTextNumber = findViewById(R.id.editTextNumber);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra(MainActivity.NOMBRE);

        saludo.setText("Hola " + nombre);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = editTextNumber.getText().toString();

                Intent intento = new Intent();
                intento.putExtra(NUMERO,numero);

                setResult(RESULT_OK,intento);
                finish();
            }
        });
    }
}