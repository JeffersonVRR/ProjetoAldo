package com.example.jeffi.projeto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Calculadora extends AppCompatActivity {
    private EditText primeiroNumero;
    private EditText segundoNumero;
    private EditText resposta;
    private Button soma;
    private Button subtracao;
    private Button multiplicacao;
    private Button divisao;
    private Button porCentagem;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculadora);
        primeiroNumero = (EditText)findViewById(R.id.primeiroNumero);
        segundoNumero = (EditText)findViewById(R.id.segundoNumero);
        soma = (Button) findViewById(R.id.soma);
        subtracao = (Button)findViewById(R.id.subtracao);
        multiplicacao = (Button)findViewById(R.id.multiplicacao);
        divisao = (Button)findViewById(R.id.divisao);
        porCentagem = (Button)findViewById(R.id.porCentagem);
        resposta = (EditText)findViewById(R.id.resposta);

        //Metodo do botão somar, somar os números informados
        soma.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Double s1 = Double.parseDouble(primeiroNumero.getText().toString());
                Double s2 = Double.parseDouble(segundoNumero.getText().toString());
                Double soma = s1 + s2;
                resposta.setText(String.valueOf(soma));
            }
        });
        //Metodo do botão subtrair, subtrair os números informados
        subtracao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Double s1 = Double.parseDouble(primeiroNumero.getText().toString());
                Double s2 = Double.parseDouble(segundoNumero.getText().toString());
                Double subtracao = s1 - s2;
                resposta.setText(String.valueOf(subtracao));
            }
        });
        //Metodo do botão multiplicar, multiplicar os números informados
        multiplicacao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Double s1 = Double.parseDouble(primeiroNumero.getText().toString());
                Double s2 = Double.parseDouble(segundoNumero.getText().toString());
                Double multiplicacao = s1 * s2;
                resposta.setText(String.valueOf(multiplicacao));
            }
        });
        //Metodo do botão dividir, divir os números informados
        divisao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Double s1 = Double.parseDouble(primeiroNumero.getText().toString());
                Double s2 = Double.parseDouble(segundoNumero.getText().toString());
                //Verificação se o número não é 0
                if (s2 == 0) {
                    String msg = "Impossível divir por 0";
                    Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
                }else {
                    Double divisao = s1 / s2;
                    resposta.setText(String.valueOf(divisao));
                }
            }
        });
        //Metodo do botão porcentagem, porcentagem os números informados
        porCentagem.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Double s1 = Double.parseDouble(primeiroNumero.getText().toString());
                segundoNumero.setText(String.valueOf(100));
                Double porCentagem = s1/100;
                resposta.setText(String.valueOf(porCentagem));
            }
        });
    }
    //Metodo do botão voltar
    public void onBackPressed(){
        startActivity(new Intent(this, MainActivity.class));
        return;
    }
}
