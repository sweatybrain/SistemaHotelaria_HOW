package com.example.sistemahotelaria_how;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Funcionario extends AppCompatActivity implements View.OnClickListener{

    private Button btnCadastrarFuncionario, btnConsultarFuncionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionario);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        InicializarComponentes();
        SetarListeners();
    }

    private void InicializarComponentes(){
        btnCadastrarFuncionario = findViewById(R.id.btn_AdicionarColaborador);
        btnConsultarFuncionario = findViewById(R.id.btn_ConsultarColaboradores);
    }

    private void SetarListeners(){
        btnCadastrarFuncionario.setOnClickListener(this);
        btnConsultarFuncionario.setOnClickListener(this);
    }

    private void AbrirTelaConsultaColaborador(){
        Intent in = new Intent(this, ConsultaCliente.class);
        startActivity(in);
    }
    private void AbrirTelaCadastraColaborador(){
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
            case R.id.btn_AdicionarColaborador:
                AbrirTelaCadastraColaborador();
                break;
            case R.id.btn_ConsultarColaboradores:
                AbrirTelaConsultaColaborador();
                break;
        }
    }
}