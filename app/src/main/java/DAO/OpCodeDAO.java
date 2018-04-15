package DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Path;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Entity.Instruction;
import Entity.Operator;
import Entity.OpCode;

public class OpCodeDAO {
    private static final String TABLE_OP_CODE = "table_op_code";
    private static final String COL_ID = "HEXA_ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_INSTRUCTION = "INSTRUCTION_ID";
    private static final int NUM_COL_INSTRUCTION = 1;
    private static final String COL_OPERATOR_SRC = "OPERATOR_SRC_ID";
    private static final int NUM_COL_OPERATOR_SRC = 2;
    private static final String COL_OPERATOR_BUT = "OPERATOR_BUT_ID";
    private static final int NUM_COL_OPERATOR_BUT = 3;

    private static final String[] columns = new String[] {COL_ID, COL_INSTRUCTION, COL_OPERATOR_SRC, COL_OPERATOR_BUT};

    SQLiteDatabase db;
    InstructionDAO dataInstruction;
    OperatorDAO dataOperator;

    public OpCodeDAO (SQLiteDatabase db){
        this.db = db;
        dataInstruction = new InstructionDAO(db);
        dataOperator = new OperatorDAO(db);
    }

    public long insertOpCode(OpCode opCode){
        ContentValues values = new ContentValues();
        if(opCode == null
                || opCode.getInstruction() == null) return -6;
        values.put(COL_ID, opCode.getHexa_id());
        values.put(COL_INSTRUCTION, opCode.getInstruction().getId());
        values.put(COL_OPERATOR_SRC, (opCode.getOperatorSrc() != null) ? opCode.getOperatorSrc().getId() : null);
        values.put(COL_OPERATOR_BUT, (opCode.getOperatorBut() != null) ? opCode.getOperatorBut().getId() : null);
        return db.insert(TABLE_OP_CODE, null, values);
    }

    public int updateOpCode(OpCode opCode){
        ContentValues values = new ContentValues();
        if(opCode == null
                && opCode.getInstruction() == null
                && opCode.getOperatorSrc() == null
                && opCode.getOperatorBut() == null) return -6;
        values.put(COL_INSTRUCTION, opCode.getInstruction().getId());
        if(opCode.getOperatorSrc() != null)
        values.put(COL_OPERATOR_SRC, opCode.getOperatorSrc().getId());
        if(opCode.getOperatorBut() != null)
        values.put(COL_OPERATOR_BUT, opCode.getOperatorBut().getId());
        String whereClause = COL_ID + " = " + opCode.getHexa_id();
        return db.update(TABLE_OP_CODE, values, whereClause, null);
    }

    public int removeOpCodeById(String id){
        String whereClasue = COL_ID+" = "+id;
        return db.delete(TABLE_OP_CODE, whereClasue, null);
    }

    public OpCode getById(String id){
        String selection = COL_ID+" = \""+id+"\"";
        Cursor c = db.query(TABLE_OP_CODE, columns, selection, null, null, null, null);
        return cursorToOpCode(c);
    }

    public List<OpCode> getByInstructionId(int id){
        String selection = COL_INSTRUCTION +" = "+id;
        Cursor c = db.query(TABLE_OP_CODE, columns, selection, null, null, null, null);
        List<OpCode> opCodes = new ArrayList<>();
        while(!c.isAfterLast() && !c.isClosed()){
            opCodes.add(cursorToOpCode(c));
        }
        return opCodes;
    }

    public List<OpCode> getAll(){
        Cursor c = db.query(TABLE_OP_CODE, columns, null, null, null, null, null);
        List<OpCode> l = new ArrayList<>();
        while (!c.isAfterLast() && !c.isClosed()){
            l.add(cursorToOpCode(c));
        }
        return l;
    }

    //Cette méthode permet de convertir un cursor en un op code
    private OpCode cursorToOpCode(Cursor c){
        if (c.getCount() == 0)
            return null;

        if (c.isBeforeFirst())
            c.moveToFirst();

        OpCode opCode = new OpCode();
        opCode.setHexa_id(c.getString(NUM_COL_ID));
        Instruction instruction = dataInstruction.getById(c.getInt(NUM_COL_INSTRUCTION));
        opCode.setInstruction(instruction);
        Operator operator = dataOperator.getById(c.getInt(NUM_COL_OPERATOR_SRC));
        opCode.setOperatorSrc(operator);
        operator = dataOperator.getById(c.getInt(NUM_COL_OPERATOR_BUT));
        opCode.setOperatorBut(operator);

        if(c.isLast())
            c.close();
        else
            c.moveToNext();

        return  opCode;
    }
}
