package com.example.sistemahotelaria_how;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroFuncionario extends AppCompatActivity {


    private EditText txtNome,
            txtCpf,
            txtDatNascimento,
            txtTelefone,
            txtNacionalidade,
            txtLogradouro,
            txtCep,
            txtComplemento,
            txtNumero;

    private Button btnSalvarFuncionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_funcionario);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        InicializarComponentes();
        SetarListeners();
    }


    private void InicializarComponentes(){
        txtNome = findViewById(R.id.txt_nome_funcionario);
        txtCpf = findViewById(R.id.txt_cpf_funcionario);
/*        txtDatNascimento = findViewById(R.id.txt_datNascimento_funcionario);
        txtTelefone = findViewById(R.id.txt_telefone_funcionario);
        txtNacionalidade = findViewById(R.id.txt_nacionalidade_funcionario);
        txtLogradouro = findViewById(R.id.txt_logradouro_funcionario);
        txtCep = findViewById(R.id.txt_cep_funcionario);
        txtComplemento = findViewById(R.id.txt_complemento_funcionario);
        txtNumero = findViewById(R.id.txt_numero_funcionario);*/
        btnSalvarFuncionario = findViewById(R.id.btn_salvar_funcionario);
    }

    private void SetarListeners(){
        btnSalvarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //salvar o obj cliente no banco
                FuncionarioModel oFuncionario = new FuncionarioModel();
                oFuncionario.setNome(txtNome.getText().toString());
                oFuncionario.setCpf(txtCpf.getText().toString());
/*
                oFuncionario.setDataNascimento(txtDatNascimento.getText().toString());
                oFuncionario.setTelefone(txtTelefone.getText().toString());
                oFuncionario.setNacionalidade(txtNacionalidade.getText().toString());
                oFuncionario.setEndereco(txtLogradouro.getText().toString());
                oFuncionario.setEndereco(txtCep.getText().toString());
                oFuncionario.setEndereco(txtComplemento.getText().toString());
                oFuncionario.setEndereco(txtNumero.getText().toString());
*/

                DataBaseHelper dbContext = new DataBaseHelper(getApplicationContext());
                dbContext.createFuncionario(oFuncionario);
                onSupportNavigateUp();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}