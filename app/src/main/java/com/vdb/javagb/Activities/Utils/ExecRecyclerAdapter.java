package com.vdb.javagb.Activities.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vdb.javagb.Activities.GBDB;
import com.vdb.javagb.Activities.ManageGBDB;
import com.vdb.javagb.R;

import Entity.OpCode;

public class ExecRecyclerAdapter extends RecyclerView.Adapter<ExecRecyclerAdapter.ViewHolder> {
    private int[] mDataset;
    private Context mContext;
    private ManageGBDB mGBDB;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mLinearLayout;
        public ViewGroup mParent;
        public ViewHolder(LinearLayout linearLayout, ViewGroup parent){
            super(linearLayout);
            mLinearLayout = linearLayout;
            mParent = parent;
        }
    }

    public ExecRecyclerAdapter(int[] executions, Context context){
        mDataset = executions;
        mContext = context;
        mGBDB = new ManageGBDB(mContext);
    }

    @Override
    public ExecRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.debug_line, parent, false);

        ViewHolder vh = new ViewHolder(linearLayout, parent);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView textViewAdresse = (TextView) holder.mLinearLayout.findViewById(R.id.textViewAdresse);
        TextView textViewInstruction = (TextView) holder.mLinearLayout.findViewById(R.id.textViewInstruction);
        TextView textViewOperateurs = (TextView) holder.mLinearLayout.findViewById(R.id.textViewOperateurs);

        String s = Integer.toHexString(mDataset[position]);
        String hex = "0x" + (s.equals("0") ? "00" : s);
        mGBDB.open();
        OpCode opCode = mGBDB.getDataOpCode().getById(hex);

        textViewAdresse.setText(String.valueOf(position));
        textViewInstruction.setText(opCode.getInstruction().getLibelle());
        textViewOperateurs.setText(
                (opCode.getOperatorSrc() != null) ? opCode.getOperatorSrc().getLibelle() + ", " : ""
                + ((opCode.getOperatorBut() != null) ? opCode.getOperatorBut().getLibelle() : "")
        );
    }

    @Override
    public int getItemCount() {
        return (mDataset != null)? mDataset.length : 0;
    }
}
