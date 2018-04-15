package DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import Entity.Instruction;
import Entity.Operator;

public class OperatorDAO {
    private static final String TABLE_OPERATOR = "table_operator";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_LIBELLE = "LIBELLE";
    private static final int NUM_COL_LIBELLE = 1;

    private static final String[] columns = new String[] {COL_ID, COL_LIBELLE};

    SQLiteDatabase db;

    public OperatorDAO (SQLiteDatabase db){
        this.db = db;
    }

    public long insertOperator(Operator operator){
        ContentValues values = new ContentValues();
        if(operator == null && operator.getLibelle() == null) return -6;
        values.put(COL_LIBELLE, operator.getLibelle());
        return db.insert(TABLE_OPERATOR, null, values);
    }

    public int updateOperator(Operator operator){
        ContentValues values = new ContentValues();
        if(operator == null && operator.getLibelle() == null) return -6;
        values.put(COL_LIBELLE, operator.getLibelle());
        String whereClause = COL_ID + " = " + operator.getId();
        return db.update(TABLE_OPERATOR, values, whereClause, null);
    }

    public int removeOperatorById(int id){
        String whereClasue = COL_ID+" = "+id;
        return db.delete(TABLE_OPERATOR, whereClasue, null);
    }

    public Operator getById(int id){
        String selection = COL_ID+" = "+id;
        Cursor c = db.query(TABLE_OPERATOR, columns, selection, null, null, null, null);
        return cursorToOperator(c);
    }

    public Operator getByLibelle(String libelle){
        String selection = COL_LIBELLE+" = \""+libelle+"\"";
        Cursor c = db.query(TABLE_OPERATOR, columns, selection, null, null, null, null);
        return cursorToOperator(c);
    }

    public List<Operator> getAll(){
        Cursor c = db.query(TABLE_OPERATOR, columns, null, null, null, null, null);
        List<Operator> l = new ArrayList<>();
        while (!c.isAfterLast() && !c.isClosed()){
            l.add(cursorToOperator(c));
        }
        return l;
    }

    //Cette méthode permet de convertir un cursor en une question
    private Operator cursorToOperator(Cursor c){
        if (c.getCount() == 0){
            c.close();
            return null;
        }


        if (c.isBeforeFirst())
            c.moveToFirst();

        Operator operator = new Operator();
        operator.setId(c.getInt(NUM_COL_ID));
        operator.setLibelle(c.getString(NUM_COL_LIBELLE));

        if(c.isLast())
            c.close();
        else
            c.moveToNext();

        return  operator;
    }
}
