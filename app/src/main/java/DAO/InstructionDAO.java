package DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vdb.javagb.Activities.GBDB;

import java.util.ArrayList;
import java.util.List;

import Entity.Instruction;
import Entity.OpCode;

public class InstructionDAO {
    private static final String TABLE_INSTRUCTION = "table_instruction";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_LIBELLE = "LIBELLE";
    private static final int NUM_COL_LIBELLE = 1;
    private static final String COL_DESCRIPTION = "DESCRIPTION";
    private static final int NUM_COL_DESCRIPTION = 2;

    private static final String[] columns = new String[] {COL_ID, COL_LIBELLE, COL_DESCRIPTION};

    SQLiteDatabase db;

    public InstructionDAO (SQLiteDatabase db){
        this.db = db;
    }

    public long insertInstruction(Instruction instruction){
        ContentValues values = new ContentValues();
        if(instruction == null && instruction.getLibelle() == null) return -6;
        values.put(COL_LIBELLE, instruction.getLibelle());
        values.put(COL_DESCRIPTION, instruction.getDescription());
        return db.insert(TABLE_INSTRUCTION, null, values);
    }

    public int updateInsruction(Instruction instruction){
        ContentValues values = new ContentValues();
        if(instruction == null && instruction.getLibelle() == null) return -6;
        values.put(COL_LIBELLE, instruction.getLibelle());
        values.put(COL_DESCRIPTION, instruction.getDescription());
        String whereClause = COL_ID + " = " + instruction.getId();
        return db.update(TABLE_INSTRUCTION, values, whereClause, null);
    }

    public int removeInstructionById(int id){
        String whereClasue = COL_ID+" = "+id;
        OpCodeDAO dataOpCode = new OpCodeDAO(db);
        for (OpCode opCode : dataOpCode.getByInstructionId(id)){
            dataOpCode.removeOpCodeById(opCode.getHexa_id());
        }
        return db.delete(TABLE_INSTRUCTION, whereClasue, null);
    }

    public Instruction getById(int id){
        String selection = COL_ID+" = "+id;
        Cursor c = db.query(TABLE_INSTRUCTION, columns, selection, null, null, null, null);
        return cursorToInstruction(c);
    }

    public Instruction getByLibelle(String libelle){
        String selection = COL_LIBELLE+" = \""+libelle+"\"";
        Cursor c = db.query(TABLE_INSTRUCTION, columns, selection, null, null, null, null);
        return cursorToInstruction(c);
    }

    public List<Instruction> getAll(){
        Cursor c = db.query(TABLE_INSTRUCTION, columns, null, null, null, null, null);
        List<Instruction> l = new ArrayList<>();
        while (!c.isAfterLast() && !c.isClosed()){
            l.add(cursorToInstruction(c));
        }
        return l;
    }

    //Cette méthode permet de convertir un cursor en une question
    private Instruction cursorToInstruction(Cursor c){
        if (c.getCount() == 0)
            return null;

        if (c.isBeforeFirst())
            c.moveToFirst();

        Instruction instruction = new Instruction();
        instruction.setId(c.getInt(NUM_COL_ID));
        instruction.setLibelle(c.getString(NUM_COL_LIBELLE));
        instruction.setDescription(c.getString(NUM_COL_DESCRIPTION));

        if(c.isLast())
            c.close();
        else
            c.moveToNext();

        return  instruction;
    }
}
