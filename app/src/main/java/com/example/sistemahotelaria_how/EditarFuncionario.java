package com.example.sistemahotelaria_how;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarFuncionario extends AppCompatActivity {

    private FuncionarioModel FuncionaroEdicao;

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
        setContentView(R.layout.activity_editar_funcionario);

        Bundle b = getIntent().getExtras();
        int pID = b.getInt("id");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        DataBaseHelper dbContext = new DataBaseHelper(this);
        FuncionaroEdicao = dbContext.GetByIdFuncionario(pID);

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
        txtNome.setText(FuncionaroEdicao.getNome());
        txtCpf.setText(FuncionaroEdicao.getCpf());
        txtDatNascimento.setText(FuncionaroEdicao.getDataNascimento());
        txtTelefone.setText(FuncionaroEdicao.getTelefone());
        txtNacionalidade.setText(FuncionaroEdicao.getNacionalidade());
        txtLogradouro.setText(FuncionaroEdicao.getEndereco());
        txtCep.setText(FuncionaroEdicao.getCep());
        txtComplemento.setText(FuncionaroEdicao.getComplemento());
        txtNumero.setText(FuncionaroEdicao.getNumero());
    }

    private void SetarListeners(){
        btnSalvarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FuncionarioModel oFuncionario = new FuncionarioModel();
                oFuncionario.setNome(txtNome.getText().toString());
                oFuncionario.setCpf(txtCpf.getText().toString());
                oFuncionario.setDataNascimento(txtDatNascimento.getText().toString());
                oFuncionario.setTelefone(txtTelefone.getText().toString());
                oFuncionario.setNacionalidade(txtNacionalidade.getText().toString());
                oFuncionario.setEndereco(txtLogradouro.getText().toString());
                oFuncionario.setEndereco(txtCep.getText().toString());
                oFuncionario.setEndereco(txtComplemento.getText().toString());
                oFuncionario.setEndereco(txtNumero.getText().toString());

                DataBaseHelper dbContext = new DataBaseHelper(getApplicationContext());
                dbContext.updateFuncionario(oFuncionario);
                onSupportNavigateUp();
            }
        });

        btnExcluirCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper databaseHelper = new DataBaseHelper(getApplication());
                databaseHelper.deleteFuncionario(FuncionaroEdicao);
                Toast.makeText(getApplication(), "Colaborador excluído", Toast.LENGTH_LONG).show();
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