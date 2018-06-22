package com.example.jeffi.projeto;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class Agenda_Telefonica extends Activity {
    ListView lista;
    Button adc;
    DAO dao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agenda_telefonica);
        lista = (ListView) findViewById(R.id.lista);
        adc = (Button) findViewById(R.id.adc);

        //Carregar dados do banco de dados
        final Cursor cursor;
        dao = new DAO(getBaseContext());
        cursor = dao.listaDados();

        //Colocar os dados no ListView
        final NoIdCursorWrapper nc = new NoIdCursorWrapper(cursor, CriarBanco.NUMERO);
        final String [] nomeCampo = {CriarBanco.NUMERO, CriarBanco.NOME};
        int [] idViews = {R.id.numero,R.id.nome};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(),R.layout.lista_consulta,nc,nomeCampo,idViews);
        lista.setAdapter(adapter);

        //Metodo para selecionar item da lista
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nc.moveToPosition(position);
                String codigo = nc.getString(nc.getColumnIndexOrThrow(CriarBanco.NUMERO));
                Intent intent = new Intent(Agenda_Telefonica.this, CadastroEditar.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
        //Metodo para ação do botão adicionar
       adc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Agenda_Telefonica.this,CadastroEditar.class);
                startActivity(intent);
                finish();
            }
        });
    }
    //Metodo do botão voltar
    @Override
    public void onBackPressed(){
        startActivity(new Intent(this, MainActivity.class));
        return;
    }
}
