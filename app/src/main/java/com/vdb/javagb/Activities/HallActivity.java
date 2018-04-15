package com.vdb.javagb.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.vdb.javagb.Activities.gb.FullGB;
import com.vdb.javagb.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Entity.Instruction;
import Entity.OpCode;
import Entity.Operator;

public class HallActivity extends AppCompatActivity {
    private String pathRom;
    private ManageGBDB gbdb;
    private TextView txtViewHall;
    private int j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall);
        Toolbar appToolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(appToolbar);
        getSupportActionBar().setTitle("JavaGB");
        gbdb = new ManageGBDB(this);
        txtViewHall = (TextView)findViewById(R.id.textViewScreen);

        Log.i("test", Integer.toHexString(212));

        //addData();
        showData();

        String path = Environment.getExternalStorageDirectory().toString();

        ImageButton imageButtonDebug = (ImageButton)findViewById(R.id.imageButtonDebug);
        imageButtonDebug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HallActivity.this, DebuggerActivity.class);
                intent.putExtra("pathRom", pathRom);
                startActivity(intent);
            }
        });

        Button imageButtonFile = (Button)findViewById(R.id.imageButtonFile);
        imageButtonFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);

                // special intent for Samsung file manager
                Intent sIntent = new Intent("com.sec.android.app.myfiles.PICK_DATA");
                // if you want any file type, you can skip next line
                sIntent.putExtra("CONTENT_TYPE", "*/*");
                sIntent.addCategory(Intent.CATEGORY_DEFAULT);

                Intent chooserIntent;
                if (getPackageManager().resolveActivity(sIntent, 0) != null){
                    // it is device with samsung file manager
                    chooserIntent = Intent.createChooser(sIntent, "Open file");
                    chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] { intent});
                }
                else {
                    chooserIntent = Intent.createChooser(intent, "Open file");
                }

                try {
                    startActivityForResult(chooserIntent, 22);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "No suitable File Manager was found.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null || requestCode != 22)return;
        Uri uri = data.getData();

        pathRom = data.getDataString();
        File f = new File(pathRom);
        String romName = f.getName();
        txtViewHall.setText(getString(R.string.text_screen));
        txtViewHall.setText(txtViewHall.getText()+"\n\n\n"+romName);

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void showData(){
        gbdb.open();
        for (OpCode opCode : gbdb.getDataOpCode().getAll()){
            Log.i("OpCode", opCode.getRow());
        }

        for (Instruction instruction : gbdb.getDataInstruction().getAll()){
            Log.i("Instruction", instruction.getRow());
        }

        for (Operator operator : gbdb.getDataOperator().getAll()){
            Log.i("Operator", operator.getRow());
        }
        gbdb.close();
    }

    private void addData(){
        gbdb.open();
        /*String[] instructions = new String[] {
                "LD","LDI","LDD","PUSH","POP","ADD",
                "ADC","SUB","SBC","AND","XOR","OR",
                "CP","INC","DEC","DAA","CPL","RLCA",
                "RRCA","RRA","RLC","RL","RRC","RR",
                "SLA","SWAP","SRA","SRL","BIT","SET",
                "RES","NOP","JR","JP","RETI","HALT",
                "STOP"};

        String[] operators = new String[] {
                "a","b","c","d","e",
                "h","l","AF","BC","DE",
                "HL","SP","(AF)","(BC)","(DE)",
                "(HL)","(SP)","n","nn","(nn)",
                "HALT", "STOP", "IO", "0","1",
                "2","3","4","5","6",
                "7","f","38","30","28",
                "20","18","fC","10","08",
                "fZ","00","c","(c)","NOP"};

        for (int i = 0; i < instructions.length; i++){
            Instruction instruction = new Instruction();
            instruction.setLibelle(instructions[i]);
            gbdb.getDataInstruction().insertInstruction(instruction);
        }

        for (int i = 0; i < operators.length; i++){
            Operator operator = new Operator();
            operator.setLibelle(operators[i]);
            gbdb.getDataOperator().insertOperator(operator);
        }*/

        /*for (String[] opCode : opCodes){
            OpCode opC = new OpCode();
            opC.setHexa_id(opCode[0]);
            Instruction instruction = gbdb.getDataInstruction().getByLibelle(opCode[1]);
            opC.setInstruction(instruction);
            Operator operator = (opCode[2] != null) ? gbdb.getDataOperator().getByLibelle(opCode[2]) : null;
            opC.setOperatorSrc(operator);
            Operator operatorBut = (opCode[3] != null) ? gbdb.getDataOperator().getByLibelle(opCode[3]) : null;
            opC.setOperatorBut(operatorBut);
            gbdb.getDataOpCode().insertOpCode(opC);
        }
        gbdb.close();*/
    }
}
