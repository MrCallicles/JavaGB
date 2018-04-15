package com.vdb.javagb.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.vdb.javagb.Activities.Utils.ExecRecyclerAdapter;
import com.vdb.javagb.Activities.gb.FullGB;
import com.vdb.javagb.Activities.gb.memory.TestRom;
import com.vdb.javagb.R;

import java.util.ArrayList;
import java.util.List;
import Entity.OpCode;

public class DebuggerActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<OpCode> mOpCodes;
    private FullGB mFullGb;
    private ManageGBDB mGbdb;
    private int currentAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debugger);

        String pathRom = getIntent().getStringExtra("pathRom");
        TestRom testRom = new TestRom();
        mGbdb = new ManageGBDB(this);
        mFullGb = new FullGB(testRom.testRom);
        mOpCodes = new ArrayList<OpCode>();

        initList();

        ImageView buttonRun = (ImageView)findViewById(R.id.buttonRun);
        buttonRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBreakpoints();
                //what to do;
            }
        });

        ImageView buttonStep = (ImageView)findViewById(R.id.buttonStep);
        buttonStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFullGb.step();
            }
        });
    }

    protected void initList(){

        mGbdb.open();
        int[] ram = mFullGb.dumpRam();
        List<OpCode> opCodes = mGbdb.getDataOpCode().getAll();
        mGbdb.close();
        boolean cb = false;

        for (int i : ram){
            //si i vaut la valeur décimale de cb
            if (i == 203) { cb = true; continue; }
            String code;
            if(cb){
                code = "cb_"+((i < 16)?"0"+Integer.toHexString(i):Integer.toHexString(i));
                cb = false;
            } else {
                code = (i < 16)?"0"+Integer.toHexString(i):Integer.toHexString(i);
            }
            OpCode opCode = null;
            String hex = "0x"+code;
            for (OpCode opcode : opCodes){
                if(opcode.getHexa_id().equals(hex)){
                    opCode = new OpCode(opcode);
                    break;
                }
            }

            if(opCode != null && opCode.getInstruction() != null)
                mOpCodes.add(opCode);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewDebug);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ExecRecyclerAdapter(mOpCodes, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setBreakpoints(){
        for(OpCode opCode : mOpCodes) {
            if(opCode.isSelected()){
                mFullGb.addBreakpoint(opCode.getPosition());
            } else {
                mFullGb.clearBreakpoint(opCode.getPosition());
            }
        }
    }
}
