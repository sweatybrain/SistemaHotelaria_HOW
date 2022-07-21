package com.example.sistemahotelaria_how;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hospedes extends AppCompatActivity implements View.OnClickListener{

    private Button btnCadastrarHospede, btnConsultarHospede;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospedes);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        InicializarComponentes();
        SetarListeners();
    }

    private void InicializarComponentes(){
        btnCadastrarHospede = findViewById(R.id.btn_AdicionarHospedes);
        btnConsultarHospede = findViewById(R.id.btn_ConsultarHospedes);
    }

    private void SetarListeners(){
        btnCadastrarHospede.setOnClickListener(this);
        btnConsultarHospede.setOnClickListener(this);
    }

    private void AbrirTelaConsultaHospede(){
        Intent in = new Intent(this, ConsultaCliente.class);
        startActivity(in);
    }
    private void AbrirTelaCadastraHospede(){
        Intent in = new Intent(this, CadastroCliente.class);
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
            case R.id.btn_AdicionarHospedes:
                AbrirTelaCadastraHospede();
                break;
            case R.id.btn_ConsultarHospedes:
                AbrirTelaConsultaHospede();
                break;
        }
    }
}