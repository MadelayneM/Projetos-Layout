package com.example.projetopoupanca;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etValorInicial, etAplicacaoMensal, etTempoAplicacao, etTaxa;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etValorInicial = findViewById(R.id.etValorInicial);
        etAplicacaoMensal = findViewById(R.id.etAplicacaoMensal);
        etTempoAplicacao = findViewById(R.id.etTempoAplicacao);
        etTaxa = findViewById(R.id.etTaxa);
        btnCalcular = findViewById(R.id.btnCalcular);



        btnCalcular.setOnClickListener(v -> {
            String valorInicial = etValorInicial.getText().toString().trim();
            String apliccaoMensal = etAplicacaoMensal.getText().toString().trim();
            String tempoAplicacao = etTempoAplicacao.getText().toString().trim();
            String taxa = etTaxa.getText().toString().trim();

            if(!valorInicial.isEmpty() && !apliccaoMensal.isEmpty() && !tempoAplicacao.isEmpty() && !taxa.isEmpty()){
                Toast.makeText(this,"Operação realizada com sucesso!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Campo Vazio!! Digite um valor", Toast.LENGTH_SHORT).show();
            }
        });
    }
}