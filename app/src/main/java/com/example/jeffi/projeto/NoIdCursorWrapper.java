package com.example.jeffi.projeto;

import android.database.Cursor;
import android.database.CursorWrapper;

//Classe para efetuar a coleta do id da coluna selecionada na ListView
public class NoIdCursorWrapper extends CursorWrapper {

    private int idColumnIndex;
    public NoIdCursorWrapper(Cursor c, int idColumnIndex) {
        super(c);
        this.idColumnIndex = idColumnIndex;
    }

    public NoIdCursorWrapper(Cursor c, String idColumnName) {
        super(c);
        idColumnIndex = c.getColumnIndex(idColumnName);
    }

    @Override
    public int getColumnIndex(String columnName) {
        int index = super.getColumnIndex(columnName);
        if (index < 0 && "_id".equals(columnName)) {
            index = idColumnIndex;
        }
        return index;
    };

    @Override
    public int getColumnIndexOrThrow(String columnName) throws
            IllegalArgumentException {
        int index = getColumnIndex(columnName);
        if (index>=0) {
            return index;
        }
        return super.getColumnIndexOrThrow(columnName);
    };
}
