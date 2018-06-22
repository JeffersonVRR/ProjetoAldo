package com.example.jeffi.projeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button calculadora;
    private Button navegador;
    private Button mostraMapa;
    private Button agendaTelefonica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculadora = (Button) findViewById(R.id.calculadora);
        navegador = (Button) findViewById(R.id.navegador);
        mostraMapa = (Button) findViewById(R.id.meMostraMapa);
        agendaTelefonica = (Button) findViewById(R.id.agendaTelefonica);

        //Metodo do botão para abrir tela da calculadora
        calculadora.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Calculadora.class);
                startActivity(intent);
                finish();
            }
        });

        //Metodo do botão para abrir tela do navegador
        navegador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Navegador.class);
                startActivity(intent);
                finish();
            }
        });

        //Metodo do botão para abrir tela do mapa
        mostraMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Me_Mostra_Mapa.class);
                startActivity(intent);
                finish();
            }
        });

        //Metodo do botão para abrir tela da agenda telefonica
        agendaTelefonica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, Agenda_Telefonica.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

