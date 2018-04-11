package com.vdb.javagb.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.vdb.javagb.Activities.gb.FullGB;
import com.vdb.javagb.R;

import java.util.List;

import Entity.OpCode;

public class DebuggerActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int[] mExecutions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debugger);

        String pathRom = getIntent().getStringExtra("pathRom");

        FullGB fullGb = new FullGB(pathRom);

        setTitle("Debug");

    }

    protected void initializeList(){

    }
}
