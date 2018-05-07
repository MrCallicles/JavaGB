package com.vdb.javagb.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.vdb.javagb.Activities.Utils.ExecRecyclerAdapter;
import com.vdb.javagb.gb.Decompiler;
import com.vdb.javagb.gb.FullGB;
import com.vdb.javagb.gb.memory.TestRom;
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
    private Decompiler mDecompiler;
    private ExecRecyclerAdapter.ViewHolder step;
    private int currentAddress;
    private int currentPosition;
    private int previousPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debugger);

        String pathRom = getIntent().getStringExtra("pathRom");
        TestRom testRom = new TestRom();
        mFullGb = new FullGB(pathRom);
        //mFullGb = new FullGB(testRom.testRom);
        mDecompiler = mFullGb.getDecompiler();
        initList();

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                setLineChecking();
            }
        });

        ImageView buttonRun = (ImageView)findViewById(R.id.buttonRun);
        buttonRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentAddress = mFullGb.run();
                setPositionView();
            }
        });

        ImageView buttonStep = (ImageView)findViewById(R.id.buttonStep);
        buttonStep.setOnClickListener(new View.OnClickListener() {
            private boolean cb;

            @Override
            public void onClick(View view) {
                currentAddress = mFullGb.step();
                setPositionView();
            }
        });
    }


    protected void initList(){

        mOpCodes = new ArrayList<>();
        ArrayList<String[]> ramor = mDecompiler.decompileRom();
        boolean cb = false;

        int p = 0;
        for (String[] ts : ramor){
            OpCode opCode = new OpCode(ts);
            opCode.setAddress(Integer.parseInt(ts[0]));
            opCode.setPosition(p);
            mOpCodes.add(opCode);
            p++;
        }


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewDebug);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ExecRecyclerAdapter(mOpCodes, this);
        mRecyclerView.setAdapter(mAdapter);
        ((ExecRecyclerAdapter) mAdapter).setFullGB(mFullGb);
    }

    private void setPositionView(){
        int last = ((LinearLayoutManager) mLayoutManager).findLastVisibleItemPosition();
        int first = ((LinearLayoutManager) mLayoutManager).findFirstVisibleItemPosition();

        int pos = 0;
        boolean curs = false;
        while(true){
            for (OpCode opCode : mOpCodes){
                if (opCode.getAddress() == currentAddress){
                    pos = opCode.getPosition();
                    curs=true;
                    break;
                }
            }
            if(curs) break;
            currentAddress = mFullGb.step();
        }

        currentPosition = pos;
        int inc = 0;
        if(pos > (last-first)/2)
            inc = pos-((last-first)/2);
        else
            setLineChecking();

        ((LinearLayoutManager) mLayoutManager).scrollToPositionWithOffset(inc, 0);
    }

    private void setLineChecking(){
        if (step != null) {
            step.mLinearLayout.setOnClickListener(null);
            step.mLinearLayout.setBackgroundColor(getColor(R.color.Transparent));
            step.mViewPosition.setTextColor(getColor(R.color.GBGrey));
            step.mViewAdresse.setTextColor(getColor(R.color.GBText));
            step.mViewHexa.setTextColor(getColor(R.color.GBText));
            step.mViewInstruction.setTextColor(getColor(R.color.GBText));
            step.mViewOperator.setTextColor(getColor(R.color.GBText));
            mOpCodes.get(previousPosition).setChecking(false);
        }
        step = (ExecRecyclerAdapter.ViewHolder) mRecyclerView.findViewHolderForAdapterPosition(currentPosition);
        if (step != null){
            step.mLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mFullGb.showRegisters();
                }
            });
            step.mLinearLayout.setBackgroundColor(getColor(R.color.GBText));
            step.mViewPosition.setTextColor(getColor(R.color.White));
            step.mViewAdresse.setTextColor(getColor(R.color.GBScreen));
            step.mViewHexa.setTextColor(getColor(R.color.GBScreen));
            step.mViewInstruction.setTextColor(getColor(R.color.GBScreen));
            step.mViewOperator.setTextColor(getColor(R.color.GBScreen));
            mOpCodes.get(currentPosition).setChecking(true);
            previousPosition = step.getAdapterPosition();
        }
    }
}
