package com.example.sistemahotelaria_how;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarCliente extends AppCompatActivity {

    private ClienteModel ClienteEdicao;

    private EditText txtNome,
            txtCpf,
            txtDatNascimento,
            txtTelefone,
            txtNacionalidade,
            txtLogradouro,
            txtCep,
            txtComplemento,
            txtNumero;

    private Button btnSalvarCliente, btnExcluirCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_cliente);

        Bundle b = getIntent().getExtras();
        int pID = b.getInt("id");

        DataBaseHelper dbContext = new DataBaseHelper(this);
        ClienteEdicao = dbContext.GetByIdCliente(pID);

        InicializarComponentes();
        SetarCampos();
        SetarListeners();
    }

    private void InicializarComponentes(){
        txtNome = findViewById(R.id.txt_nome_cliente);
        txtCpf = findViewById(R.id.txt_cpf_cliente);
        txtDatNascimento = findViewById(R.id.txt_datNascimento_cliente);
        txtTelefone = findViewById(R.id.txt_telefone_cliente);
        txtNacionalidade = findViewById(R.id.txt_nacionalidade_cliente);
        txtLogradouro = findViewById(R.id.txt_logradouro_cliente);
        txtCep = findViewById(R.id.txt_cep_cliente);
        txtComplemento = findViewById(R.id.txt_complemento_cliente);
        txtNumero = findViewById(R.id.txt_numero_cliente);
        btnSalvarCliente = findViewById(R.id.btn_salvar_cliente);
        btnExcluirCliente = findViewById(R.id.btn_excluir_cliente);
    }

    private void SetarCampos(){
        txtNome.setText(ClienteEdicao.getNome());
        txtCpf.setText(ClienteEdicao.getCpf());
        txtDatNascimento.setText(ClienteEdicao.getDataNascimento());
        txtTelefone.setText(ClienteEdicao.getTelefone());
        txtNacionalidade.setText(ClienteEdicao.getNacionalidade());
        txtLogradouro.setText(ClienteEdicao.getEndereco());
        /*txtCep.setText(ClienteEdicao.getNome());
        txtComplemento.setText(ClienteEdicao.getNome());
        txtNumero.setText(ClienteEdicao.getNome());*/
    }

    private void SetarListeners(){
        btnSalvarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClienteModel oCliente = new ClienteModel();
                oCliente.setNome(txtNome.getText().toString());
                oCliente.setCpf(txtCpf.getText().toString());
                oCliente.setDataNascimento(txtDatNascimento.getText().toString());
                oCliente.setTelefone(txtTelefone.getText().toString());
                oCliente.setNacionalidade(txtNacionalidade.getText().toString());
                oCliente.setEndereco(txtLogradouro.getText().toString());

                DataBaseHelper dbContext = new DataBaseHelper(getApplicationContext());
                dbContext.createCliente(oCliente);
                onSupportNavigateUp();
            }
        });

        btnExcluirCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper databaseHelper = new DataBaseHelper(getApplication());
                databaseHelper.deleteCliente(ClienteEdicao);
                Toast.makeText(getApplication(), "Cliente excluído", Toast.LENGTH_LONG).show();
            }
        });
    }
}