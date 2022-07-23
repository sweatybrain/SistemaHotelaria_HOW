package com.example.sistemahotelaria_how;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class ConsultaFuncionario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_funcionario);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DataBaseHelper dbContext = new DataBaseHelper(this);
        ListView lv = findViewById(R.id.lv_listar_funcionarios);
        dbContext.GetAllFuncionarios(this,lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                TextView tvId = view.findViewById(R.id.txtIdListarPessoa);
                Bundle b = new Bundle();
                b.putInt("id", Integer.parseInt(tvId.getText().toString()));

                Intent in = new Intent(getApplication(),EditarCliente.class);
                in.putExtras(b);
                startActivity(in);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}