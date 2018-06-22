package com.example.jeffi.projeto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DAO {
    private CriarBanco banco;
    private SQLiteDatabase db;

    public DAO(Context context){
        banco = new CriarBanco(context);
    }

    //Metodo para adicionar dados no banco de dados
    public String insereDado(Integer numero, String nome){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.NUMERO, numero);
        valores.put(CriarBanco.NOME, nome);

        resultado = db.insert(CriarBanco.TABELA, null, valores);
        db.close();

        if (resultado == -1){
            return "Erro ao adicionar dados";
        }else {
            return "Adicionado com sucesso";
        }
    }

    //Metodo para listar dados sem ID
    public Cursor listaDados(){
        Cursor cursor;
        String [] campos = {banco.NUMERO,banco.NOME};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos,null,null,null,null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    //Metodo para listar dados com ID
    public Cursor listaDadosPorId(Integer numero){
        Cursor cursor;
        String [] campos = {banco.NUMERO, banco.NOME};
        String where = CriarBanco.NUMERO + "=" + numero;
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, where,null,null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    //Metodo para alterar dados por ID
    public void alterarDado(Integer numero, String nome){
        ContentValues valores;
        String where;
        db = banco.getWritableDatabase();
        where = CriarBanco.NUMERO + "=" + numero;
        valores = new ContentValues();
        valores.put(CriarBanco.NOME, nome);

        db.update(CriarBanco.TABELA,valores,where,null);
        db.close();
    }

    //Metodo para deletar dados por ID
    public void deletar(Integer numero){
        String where = CriarBanco.NUMERO + "=" + numero;
        db = banco.getReadableDatabase();
        db.delete(CriarBanco.TABELA,where,null);
        db.close();
    }
}