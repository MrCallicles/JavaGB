package com.vdb.javagb.Utility;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vdb.javagb.gb.FullGB;
import com.vdb.javagb.R;

import java.util.List;

import com.vdb.javagb.Entity.OpCode;

public class ExecRecyclerAdapter extends RecyclerView.Adapter<ExecRecyclerAdapter.ViewHolder> {
    private List<OpCode> mDataset;
    private Context mContext;
    private FullGB mFullGB;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mLinearLayout;
        public ImageView mButtonBreakpoint;
        public TextView mViewPosition;
        public TextView mViewAdresse;
        public TextView mViewInstruction;
        public TextView mViewOperator;
        public ViewGroup mParent;

        public ViewHolder(LinearLayout linearLayout, ViewGroup parent){
            super(linearLayout);
            mLinearLayout = linearLayout;
            mButtonBreakpoint = (ImageView) mLinearLayout.findViewById(R.id.buttonBreakpoint);
            mViewPosition = (TextView) mLinearLayout.findViewById(R.id.textViewPosition);
            mViewAdresse = (TextView) mLinearLayout.findViewById(R.id.textViewAdresse);
            mViewInstruction = (TextView) mLinearLayout.findViewById((R.id.textViewInstruction));
            mViewOperator = (TextView) mLinearLayout.findViewById((R.id.textViewOperateurs));
            mParent = parent;
        }
    }

    public ExecRecyclerAdapter(List<OpCode> opCodes, Context context){
        mDataset = opCodes;
        mContext = context;
    }

    @Override
    public ExecRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.debug_line, parent, false);

        ViewHolder vh = new ViewHolder(linearLayout, parent);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final OpCode opCode = mDataset.get(position);
        holder.mViewPosition.setText(""+opCode.getPosition());
        holder.mViewAdresse.setText(String.format("0x%04x", opCode.getAddress()));
        holder.mViewInstruction.setText(opCode.getCode()[1]);
        holder.mViewOperator.setText(
                (!opCode.getCode()[2].isEmpty()) ? opCode.getCode()[2] + ((!opCode.getCode()[3].isEmpty()) ? " > "+opCode.getCode()[3] : ""): ""
        );

        holder.mButtonBreakpoint.setOnClickListener(null);
        holder.mViewInstruction.setOnClickListener(null);
        holder.mLinearLayout.setBackground(null);
        holder.mViewPosition.setTextColor(mContext.getColor(R.color.GBGrey));
        holder.mViewAdresse.setTextColor(mContext.getColor(R.color.GBGrey));
        holder.mViewInstruction.setTextColor(mContext.getColor(R.color.GBGrey));
        holder.mViewOperator.setTextColor(mContext.getColor(R.color.GBGrey));

        if (opCode != null && opCode.isChecking()){
            holder.mViewInstruction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mFullGB.showRegisters();
                }
            });
            holder.mLinearLayout.setBackgroundColor(mContext.getColor(R.color.GBScreen));
            holder.mViewPosition.setTextColor(mContext.getColor(R.color.GBText));
            holder.mViewAdresse.setTextColor(mContext.getColor(R.color.GBText));
            holder.mViewInstruction.setTextColor(mContext.getColor(R.color.GBText));
            holder.mViewOperator.setTextColor(mContext.getColor(R.color.GBText));
        }

        if (opCode != null && opCode.isSelected())
            holder.mButtonBreakpoint.setBackground(mContext.getDrawable(R.drawable.breakpoint));
        else
            holder.mButtonBreakpoint.setBackground(null);

        holder.mButtonBreakpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.mButtonBreakpoint.setBackground(null);
                if(opCode!=null){
                    opCode.toggle();
                    if (opCode.isSelected()){
                        holder.mButtonBreakpoint.setBackground(mContext.getDrawable(R.drawable.breakpoint));
                        mFullGB.addBreakpoint(opCode.getAddress());
                    } else {
                        mFullGB.clearBreakpoint(opCode.getAddress());
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (mDataset != null)? mDataset.size() : 0;
    }

    public void setFullGB(FullGB fullGB){
        mFullGB = fullGB;
    }
}
