package com.example.sistemahotelaria_how;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnHospedes, btnReserva, btnOperacional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();
        SetarListeners();
    }

    private void inicializarComponentes(){
        btnHospedes = findViewById(R.id.btn_hospedes);
        btnOperacional = findViewById(R.id.btn_operacional);
        btnReserva = findViewById(R.id.btn_reservas);
    }

    private void SetarListeners(){
        btnHospedes.setOnClickListener(this);
        btnOperacional.setOnClickListener(this);
        btnReserva.setOnClickListener(this);
    }

    private void AbrirTelaHospedes(){
        Intent in = new Intent(this, Hospedes.class);
        startActivity(in);
    }

    private void AbrirTelaOperacional(){
        Intent in = new Intent(this, Funcionario.class);
        startActivity(in);
    }

    private void AbrirTelaReservas(){
        Intent in = new Intent(this, Reservas.class);
        startActivity(in);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_hospedes:
                AbrirTelaHospedes();
                break;
            case R.id.btn_operacional:
                AbrirTelaOperacional();
                break;
            case R.id.btn_reservas:
                AbrirTelaReservas();
                break;
        }
    }

}