package com.example.jeffi.projeto;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CadastroEditar extends AppCompatActivity{
    EditText numero;
    EditText nome;
    Button salva;
    Button edita;
    Button deleta;
    String codigo;
    DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_editar);
        numero = (EditText) findViewById(R.id.numero);
        nome = (EditText) findViewById(R.id.nome);
        edita = (Button) findViewById(R.id.editar);
        salva = (Button) findViewById(R.id.salvar);
        deleta = (Button) findViewById(R.id.deletar);

        //Coletando o ID da ListView
        codigo = this.getIntent().getStringExtra("codigo");
        dao = new DAO(getBaseContext());

        //Verificando se o possui um ID ou não
        if (codigo == null){
            //Se não
            //Desabilita os botões de editar e deletar
            edita.setEnabled(false);
            deleta.setEnabled(false);

            //Metodo da ação do botão salvar, adicionar informaçoes no banco de dados
            salva.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer num = Integer.parseInt(numero.getText().toString());
                    String resultado;
                    resultado = dao.insereDado(num,nome.getText().toString());
                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                }
            });
        }else {
            //Se sim
            //Desabilita o botão salvar e o campo do ID
            numero.setEnabled(false);
            salva.setEnabled(false);

            //Coleta os dados daquele ID
            Cursor cursos = dao.listaDadosPorId(Integer.parseInt(codigo));
            numero.setText(cursos.getString(cursos.getColumnIndexOrThrow(CriarBanco.NUMERO)));
            nome.setText(cursos.getString(cursos.getColumnIndexOrThrow(CriarBanco.NOME)));

            //Metodo para ação do botão editar, alterar informações no banco de dados
            edita.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dao.alterarDado(Integer.parseInt(codigo), nome.getText().toString());
                    Intent intent = new Intent(CadastroEditar.this,Agenda_Telefonica.class);
                    startActivity(intent);
                    finish();
                }
            });
            //Metodo para ação do botão deletar, deletar informações no banco de dados
            deleta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dao.deletar(Integer.parseInt(codigo));
                    Intent intent = new Intent(CadastroEditar.this,Agenda_Telefonica.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }
    //Metodo do botão voltar
    @Override
    public void onBackPressed(){
        startActivity(new Intent(this, Agenda_Telefonica.class));
        return;
    }
}

