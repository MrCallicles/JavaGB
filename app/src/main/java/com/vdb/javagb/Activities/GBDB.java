package com.vdb.javagb.Activities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GBDB extends SQLiteOpenHelper {
    private static final String TABLE_INSTRUCTION = "table_instruction";
    private static final String TABLE_OPERATOR = "table_operator";
    private static final String TABLE_OP_CODE = "table_op_code";

    //for all
    private static final String COL_ID ="ID";
    private static final String COL_LIBELLE = "LIBELLE";

    //instruction
    private static final String COL_DESCRIPTION = "DESCRIPTION";

    //op codes
    private static final String COL_HEXA_ID = "HEXA_ID";
    private static final String COL_INSTRUCTION_ID = "INSTRUCTION_ID";
    private static final String COL_OPERATOR_SRC_ID = "OPERATOR_SRC_ID";
    private static final String COL_OPERATOR_BUT_ID = "OPERATOR_BUT_ID";

    private static final String CREATE_TABLE_INSTRUCTION = "CREATE TABLE " + TABLE_INSTRUCTION + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_LIBELLE + " TEXT NOT NULL,"
            + COL_DESCRIPTION + " TEXT);";

    private static final String CREATE_TABLE_OPERATORS = "CREATE TABLE " + TABLE_OPERATOR + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_LIBELLE + " TEXT NOT NULL);";

    private static final String CREATE_TABLE_OP_CODES = "CREATE TABLE " + TABLE_OP_CODE + " ("
            + COL_HEXA_ID + " TEXT PRIMARY KEY NOT NULL, "
            + COL_INSTRUCTION_ID + " INTEGER NOT NULL, "
            + COL_OPERATOR_SRC_ID + " INTEGER, "
            + COL_OPERATOR_BUT_ID + " INTEGER, "
            + "FOREIGN KEY(" + COL_INSTRUCTION_ID +") REFERENCES " + TABLE_INSTRUCTION + " ( " + COL_ID + "),"
            + "FOREIGN KEY(" + COL_OPERATOR_SRC_ID +") REFERENCES " + TABLE_OPERATOR + " ( " + COL_ID + "),"
            + "FOREIGN KEY(" + COL_OPERATOR_BUT_ID +") REFERENCES " + TABLE_OPERATOR + " ( " + COL_ID + "));";

    public GBDB (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context ,name , factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_INSTRUCTION);
        sqLiteDatabase.execSQL(CREATE_TABLE_OPERATORS);
        sqLiteDatabase.execSQL(CREATE_TABLE_OP_CODES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_OP_CODE + ";");
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_INSTRUCTION + ";");
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_OPERATOR + ";");
        onCreate(sqLiteDatabase);
    }
}
