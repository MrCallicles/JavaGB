package com.vdb.javagb.Activities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import DAO.InstructionDAO;
import DAO.OpCodeDAO;
import DAO.OperatorDAO;

public class ManageGBDB {
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "javagb.db";

    private GBDB GBDB;
    private SQLiteDatabase db;

    private InstructionDAO dataInstruction;
    private OperatorDAO dataOperator;
    private OpCodeDAO dataOpCode;

    public ManageGBDB(Context context){
        //On crée la BDD et sa table
        GBDB = new GBDB(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        db = GBDB.getWritableDatabase();
        dataInstruction = new InstructionDAO(db);
        dataOperator = new OperatorDAO(db);
        dataOpCode = new OpCodeDAO(db);
    }

    public void close(){
        db.close();
    }

    public OpCodeDAO getDataOpCode() {
        return dataOpCode;
    }

    public InstructionDAO getDataInstruction() {
        return dataInstruction;
    }

    public OperatorDAO getDataOperator() {
        return dataOperator;
    }
}
