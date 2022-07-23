package com.example.sistemahotelaria_how;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroCliente extends AppCompatActivity {

    private EditText txtNome,
            txtCpf,
            txtDatNascimento,
            txtTelefone,
            txtNacionalidade,
            txtLogradouro,
            txtCep,
            txtComplemento,
            txtNumero;

    private Button btnSalvarCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        InicializarComponentes();
        SetarListeners();
    }

    private void InicializarComponentes(){
        txtNome = findViewById(R.id.txt_nome_cliente);
        txtCpf = findViewById(R.id.txt_cpf_cliente);
/*        txtDatNascimento = findViewById(R.id.txt_datNascimento_cliente);
        txtTelefone = findViewById(R.id.txt_telefone_cliente);
        txtNacionalidade = findViewById(R.id.txt_nacionalidade_cliente);
        txtLogradouro = findViewById(R.id.txt_logradouro_cliente);
        txtCep = findViewById(R.id.txt_cep_cliente);
        txtComplemento = findViewById(R.id.txt_complemento_cliente);
        txtNumero = findViewById(R.id.txt_numero_cliente);*/
        btnSalvarCliente = findViewById(R.id.btn_salvar_cliente);
    }

    private void SetarListeners(){
        btnSalvarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //salvar o obj cliente no banco
                ClienteModel oCliente = new ClienteModel();
                oCliente.setNome(txtNome.getText().toString());
                oCliente.setCpf(txtCpf.getText().toString());
/*                oCliente.setDataNascimento(txtDatNascimento.getText().toString());
                oCliente.setTelefone(txtTelefone.getText().toString());
                oCliente.setNacionalidade(txtNacionalidade.getText().toString());
                oCliente.setEndereco(txtLogradouro.getText().toString());*/

                DataBaseHelper dbContext = new DataBaseHelper(getApplicationContext());
                dbContext.createCliente(oCliente);
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