package com.example.sistemahotelaria_how;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroReservas extends AppCompatActivity {

    private ReservaModel ReservaEdicao;

    private EditText txtNomeHospede,
            txtNomeColaborador,
            txtDatReserva;

    private Button btnSalvarReserva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_reservas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        InicializarComponentes();
        SetarListeners();
    }
    private void InicializarComponentes(){
        txtNomeHospede = findViewById(R.id.txt_nome_hospede_reserva);
        txtNomeColaborador = findViewById(R.id.txt_colaborador_reserva);
        txtDatReserva = findViewById(R.id.txt_datReserva);

        btnSalvarReserva = findViewById(R.id.btn_salvar_reserva);
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
                dbContext.createReserva(oReserva);
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