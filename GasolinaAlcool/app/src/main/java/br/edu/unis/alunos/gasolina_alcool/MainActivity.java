package br.edu.unis.alunos.gasolina_alcool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtGasolina;
    EditText edtAlcool;
    Button btnCalculo;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregarComponentes();
    }

    protected void carregarComponentes(){
        edtGasolina = findViewById(R.id.edtGasolina);
        edtAlcool = findViewById(R.id.edtAlcool);
        btnCalculo = findViewById(R.id.btnCalculo);
        txtResultado = findViewById(R.id.txtResultado);
    }

    public void realizaCalculo(View view) {
        double gasolina = Double.parseDouble(edtGasolina.getText().toString());
        double alcool = Double.parseDouble(edtAlcool.getText().toString());

        double mediaCombustivel = 0.7 * gasolina;

        String resultadoFinal = "";

        if (alcool <= mediaCombustivel) {
             resultadoFinal = "O alcool é a melhor opção";
        }
        else {
            resultadoFinal = "A gasolina e a melhor opção";
        }

        exibeResultado(resultadoFinal);
        limpaCampos();
    }

    protected void exibeResultado(String resultadoFinal) { txtResultado.setText(resultadoFinal); }

    protected void limpaCampos() {
        edtGasolina.setText("");
        edtGasolina.requestFocus();

        edtAlcool.setText("");
        edtAlcool.requestFocus();
    }

}