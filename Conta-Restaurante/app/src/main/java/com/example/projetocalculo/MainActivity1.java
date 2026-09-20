package com.example.projetocalculo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity1 extends AppCompatActivity {
    private EditText edtConsumo, edtCouvert, edtPessoas;
    private Button btnCalcular;
    private TextView txtTaxa, txtTotal, txtPorPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtConsumo = findViewById(R.id.edtConsumo);
        edtCouvert = findViewById(R.id.edtCouvert);
        edtPessoas = findViewById(R.id.edtPessoas);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtTaxa = findViewById(R.id.txtTaxa);
        txtTotal = findViewById(R.id.txtTotal);
        txtPorPessoa = findViewById(R.id.txtPorPessoa);



        btnCalcular.setOnClickListener(v ->{
            String consumo = edtConsumo.getText().toString().trim();
            String couvert = edtCouvert.getText().toString().trim();
            String pessoas = edtPessoas.getText().toString().trim();

            if (!consumo.isEmpty() && !couvert.isEmpty() && !pessoas.isEmpty()){
                try {
                    double valorConsumo = Double.parseDouble(consumo);
                    double valorCouvert = Double.parseDouble(couvert);
                    int numeroPessoas = Integer.parseInt(pessoas);

                    if (numeroPessoas <= 0) {
                        edtPessoas.setError("O número de pessoas deve ser maior que 0");
                        return;
                    }

                    double taxa = valorConsumo * 0.1;
                    double total = valorConsumo + valorCouvert + taxa;
                    double totalPorPessoa = total / numeroPessoas;


                    txtTaxa.setText(String.format(Locale.getDefault(), "R$ %.2f", taxa));
                    txtTotal.setText(String.format(Locale.getDefault(), "R$ %.2f", total));
                    txtPorPessoa.setText(String.format(Locale.getDefault(), "R$ %.2f", totalPorPessoa));

                } catch (NumberFormatException e){
                    Toast.makeText(this, "Digite apenas números válidos", Toast.LENGTH_SHORT).show();
                }
            } else {
                if (consumo.isEmpty()) edtConsumo.setError("Preencha o consumo");
                if (couvert.isEmpty()) edtCouvert.setError("Preencha o couvert");
                if (pessoas.isEmpty()) edtPessoas.setError("Preencha o número de pessoas");
            }
        });
    }

}