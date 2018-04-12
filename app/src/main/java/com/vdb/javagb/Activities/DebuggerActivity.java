package com.vdb.javagb.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.vdb.javagb.Activities.Utils.ExecRecyclerAdapter;
import com.vdb.javagb.Activities.gb.FullGB;
import com.vdb.javagb.R;

import java.util.List;

import Entity.OpCode;

public class DebuggerActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int[] mExecutions;
    private FullGB fullGb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debugger);

        String pathRom = getIntent().getStringExtra("pathRom");

        fullGb = new FullGB(pathRom);

        initializeList();
    }

    protected void initializeList(){
        mExecutions = fullGb.dumpRam();

        for (int i : mExecutions){
            Log.i("int", String.valueOf(i));
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewDebug);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ExecRecyclerAdapter(mExecutions, this);
        mRecyclerView.setAdapter(mAdapter);
    }
}
