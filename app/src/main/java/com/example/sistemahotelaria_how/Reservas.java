package com.example.sistemahotelaria_how;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reservas extends AppCompatActivity implements View.OnClickListener{

    private Button btnCadastrarReserva, btnConsultarReserva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        InicializarComponentes();
        SetarListeners();
    }


    private void InicializarComponentes(){
        btnCadastrarReserva = findViewById(R.id.btn_AdicionarHospedes);
        btnConsultarReserva = findViewById(R.id.btn_ConsultarHospedes);
    }

    private void SetarListeners(){
        btnCadastrarReserva.setOnClickListener(this);
        btnConsultarReserva.setOnClickListener(this);
    }

    private void AbrirTelaConsultaReserva(){
        Intent in = new Intent(this, ConsultaReservas.class);
        startActivity(in);
    }
    private void AbrirTelaCadastraReserva(){
        Intent in = new Intent(this, CadastroReservas.class);
        startActivity(in);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_AdicionarReserva:
                AbrirTelaCadastraReserva();
                break;
            case R.id.btn_ConsultarReserva:
                AbrirTelaConsultaReserva();
                break;
        }
    }
}