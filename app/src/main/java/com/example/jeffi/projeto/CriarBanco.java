package com.example.jeffi.projeto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//Classe para efetuar a criação do banco de dados

public class CriarBanco extends SQLiteOpenHelper{
    private static final String NOME_BANCO = "Banco.db";
    public static final String TABELA = "agenda";
    public static final String NUMERO = "numero";
    public static final String NOME = "nome";
    private static final int VERSAO = 1;

    public CriarBanco(Context context){
        super(context, NOME_BANCO, null, VERSAO);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + NUMERO + " integer primary key not null,"
                + NOME + " text not null" + ")";

        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
