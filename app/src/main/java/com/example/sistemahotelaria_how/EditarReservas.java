package com.example.sistemahotelaria_how;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarReservas extends AppCompatActivity {

    private ReservaModel ReservaEdicao;

    private EditText txtNomeHospede,
            txtNomeColaborador,
            txtDatReserva;

    private Button btnSalvarReserva, btnExcluirReserva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_reservas);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle b = getIntent().getExtras();
        int pID = b.getInt("id");
        DataBaseHelper dbContext = new DataBaseHelper(this);
        ReservaEdicao = dbContext.GetByIdReserva(pID);

        InicializarComponentes();
        SetarCampos();
        SetarListeners();
    }


    private void InicializarComponentes(){
        txtNomeHospede = findViewById(R.id.txt_nome_hospede_reserva);
        txtNomeColaborador = findViewById(R.id.txt_colaborador_reserva);
        txtDatReserva = findViewById(R.id.txt_datReserva);

        btnSalvarReserva = findViewById(R.id.btn_salvar_cliente);
        btnExcluirReserva = findViewById(R.id.btn_excluir_cliente);
    }

    private void SetarCampos(){
        txtNomeHospede.setText(ReservaEdicao.getNomeHospede());
        txtNomeColaborador.setText(ReservaEdicao.getNomeColaborador());
        txtDatReserva.setText(ReservaEdicao.getDatReserva());
    }

    private void SetarListeners(){
        btnSalvarReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReservaModel oReserva = new ReservaModel();
                oReserva.setNomeHospede(txtNomeHospede.getText().toString());
                oReserva.setNomeColaborador(txtNomeColaborador.getText().toString());
                oReserva.setNomeHospede(txtDatReserva.getText().toString());

                DataBaseHelper dbContext = new DataBaseHelper(getApplicationContext());
                dbContext.updateReserva(oReserva);
                onSupportNavigateUp();
            }
        });

        btnExcluirReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper databaseHelper = new DataBaseHelper(getApplication());
                databaseHelper.deleteReserva(ReservaEdicao);
                Toast.makeText(getApplication(), "Reserva excluída", Toast.LENGTH_LONG).show();
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