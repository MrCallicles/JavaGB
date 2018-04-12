package com.vdb.javagb.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.vdb.javagb.Activities.gb.FullGB;
import com.vdb.javagb.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Entity.Instruction;
import Entity.OpCode;
import Entity.Operator;

public class HallActivity extends AppCompatActivity {
    private String pathRom;
    private ManageGBDB gbdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall);

        Log.i("test", Integer.toHexString(212));

        gbdb = new ManageGBDB(this);
        gbdb.open();

        /*String[] instructions = new String[] {"LD", "LDI", "LDD", "PUSH", "POP", "ADD", "ADC", "SUB", "SBC", "JR",
            "AND", "XOR", "OR", "CP", "INC", "DEC", "DAA", "CPL", "RLCA", "RRCA", "RRA", "RLC", "RL", "RRC", "RR", "SLA", "SWAP", "SRA", "SRL", "BIT", "SET", "RES", "NOP", "HALT", "STOP"};

        String[] operators = new String[] {"a","b","c","d","e","h","l","AF","BC","DE","HL","SP","(AF)","(BC)","(DE)","(HL)","(SP)","n","nn","(nn)","NOP"};

        for (int i = 0; i < instructions.length; i++){
            Instruction instruction = new Instruction();
            instruction.setLibelle(instructions[i]);
            gbdb.getDataInstruction().insertInstruction(instruction);
        }

        for (int i = 0; i < operators.length; i++){
            Operator operator = new Operator();
            operator.setLibelle(operators[i]);
            gbdb.getDataOperator().insertOperator(operator);
        }

        for (Instruction instruction : gbdb.getDataInstruction().getAll()){
            Log.i("Instruction", instruction.getLibelle());
        }

        List<String[]> opCodes = new ArrayList<String[]>();
        opCodes.add(new String[] {"0x00","NOP",null,null});
        opCodes.add(new String[] {"0x01","LD","BC","nn"});
        opCodes.add(new String[] {"0x02","LD","a","BC"});
        opCodes.add(new String[] {"0x03","INC","BC",null});
        opCodes.add(new String[] {"0x04","INC","b",null});
        opCodes.add(new String[] {"0x05","DEC","b",null});
        opCodes.add(new String[] {"0x06","LD","b","n"});
        opCodes.add(new String[] {"0x07","RLC","a",null});
        opCodes.add(new String[] {"0x09","ADD","HL","BC"});
        opCodes.add(new String[] {"0x0a","LD","a","BC"});
        opCodes.add(new String[] {"0x0b","DEC","BC",null});
        opCodes.add(new String[] {"0x0c","INC","c",null});
        opCodes.add(new String[] {"0x0d","DEC","c",null});
        opCodes.add(new String[] {"0x0e","LD","c","n"});
        opCodes.add(new String[] {"0x0f","RRC","a",null});
        opCodes.add(new String[] {"0x10","STOP",null,null});
        opCodes.add(new String[] {"0x11","LD","DE","nn"});
        opCodes.add(new String[] {"0x12","LD","DE","a"});
        opCodes.add(new String[] {"0x13","INC","DE",null});
        opCodes.add(new String[] {"0x14","INC","d",null});
        opCodes.add(new String[] {"0x15","DEC","d",null});
        opCodes.add(new String[] {"0x16","LD","d","n"});
        opCodes.add(new String[] {"0x17","RL","a",null});
        opCodes.add(new String[] {"0x18","JR","PC",null});
        opCodes.add(new String[] {"0x19","ADD","HL","DE"});
        opCodes.add(new String[] {"0x1a","LD","a","DE"});
        opCodes.add(new String[] {"0x1b","DEC","DE",null});
        opCodes.add(new String[] {"0x1c","INC","e",null});
        opCodes.add(new String[] {"0x1d","DEC","e",null});
        opCodes.add(new String[] {"0x1e","LD","e","n"});
        opCodes.add(new String[] {"0x1f","RR","a",null});
        opCodes.add(new String[] {"0x20","JR","f","PC"});
        opCodes.add(new String[] {"0x21","LD","HL","nn"});
        opCodes.add(new String[] {"0x22","LDI","HL","a"});
        opCodes.add(new String[] {"0x23","INC","HL",null});
        opCodes.add(new String[] {"0x24","INC","h",null});
        opCodes.add(new String[] {"0x25","DEC","h",null});
        opCodes.add(new String[] {"0x26","LD","h","n"});

        for (String[] opCode : opCodes){
            OpCode opC = new OpCode();
            opC.setHexa_id(opCode[0]);
            Instruction instruction = gbdb.getDataInstruction().getByLibelle(opCode[1]);
            opC.setInstruction(instruction);
            Operator operator = (opCode[2] != null) ? gbdb.getDataOperator().getByLibelle(opCode[2]) : null;
            opC.setOperatorSrc(operator);
            operator = (opCode[3] != null) ? gbdb.getDataOperator().getByLibelle(opCode[3]) : null;
            opC.setOperatorSrc(operator);
            gbdb.getDataOpCode().insertOpCode(opC);
        }*/

        for (OpCode opCode : gbdb.getDataOpCode().getAll()){
            String s = opCode.getHexa_id() + ", "
                    + opCode.getInstruction().getLibelle() + ", ";
            if (opCode.getOperatorSrc() != null)
                    s += opCode.getOperatorSrc().getLibelle() + " ";
            if (opCode.getOperatorBut() != null)
                    s += opCode.getOperatorBut().getLibelle();
            Log.i("OpCode", s);
        }

        ImageButton imageButtonDebug = (ImageButton)findViewById(R.id.imageButtonDebug);
        imageButtonDebug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HallActivity.this, DebuggerActivity.class);
                intent.putExtra("pathRom", pathRom);
                startActivity(intent);
            }
        });

        ImageButton imageButtonFile = (ImageButton)findViewById(R.id.imageButtonFile);
        imageButtonFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("text/plain");
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

        TextView textViewFile = (TextView)findViewById(R.id.textViewFile);
        textViewFile.setText(pathRom);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
