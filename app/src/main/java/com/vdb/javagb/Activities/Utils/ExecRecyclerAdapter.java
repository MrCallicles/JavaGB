package com.vdb.javagb.Activities.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.vdb.javagb.Activities.gb.FullGB;
import com.vdb.javagb.R;

import java.util.List;

import Entity.OpCode;

public class ExecRecyclerAdapter extends RecyclerView.Adapter<ExecRecyclerAdapter.ViewHolder> {
    private List<OpCode> mDataset;
    private Context mContext;
    private FullGB mFullGB;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mLinearLayout;
        public ImageView mButtonBreakpoint;
        public TextView mViewPosition;
        public TextView mViewAdresse;
        public TextView mViewHexa;
        public TextView mViewInstruction;
        public TextView mViewOperator;
        public ViewGroup mParent;

        public ViewHolder(LinearLayout linearLayout, ViewGroup parent){
            super(linearLayout);
            mLinearLayout = linearLayout;
            mButtonBreakpoint = (ImageView) mLinearLayout.findViewById(R.id.buttonBreakpoint);
            mViewPosition = (TextView) mLinearLayout.findViewById(R.id.textViewPosition);
            mViewAdresse = (TextView) mLinearLayout.findViewById(R.id.textViewAdresse);
            mViewHexa = (TextView) mLinearLayout.findViewById(R.id.textViewHexa);
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
        holder.mViewAdresse.setText(""+opCode.getAddress());
        holder.mViewHexa.setText(opCode.getHexa_id());
        holder.mViewInstruction.setText(opCode.getInstruction().getLibelle());
        holder.mViewOperator.setText(
                (opCode.getOperatorSrc() != null) ? opCode.getOperatorSrc().getLibelle() + ((opCode.getOperatorBut() != null) ? " > "+opCode.getOperatorBut().getLibelle() : ""): ""
        );

        holder.mButtonBreakpoint.setOnClickListener(null);
        holder.mLinearLayout.setBackground(null);
        holder.mViewPosition.setTextColor(mContext.getColor(R.color.GBGrey));
        holder.mViewAdresse.setTextColor(mContext.getColor(R.color.GBText));
        holder.mViewHexa.setTextColor(mContext.getColor(R.color.GBText));
        holder.mViewInstruction.setTextColor(mContext.getColor(R.color.GBText));
        holder.mViewOperator.setTextColor(mContext.getColor(R.color.GBText));

        if (opCode != null && opCode.isChecking()){
            holder.mLinearLayout.setBackgroundColor(mContext.getColor(R.color.GBText));
            holder.mViewPosition.setTextColor(mContext.getColor(R.color.GBScreen));
            holder.mViewAdresse.setTextColor(mContext.getColor(R.color.GBScreen));
            holder.mViewHexa.setTextColor(mContext.getColor(R.color.GBScreen));
            holder.mViewInstruction.setTextColor(mContext.getColor(R.color.GBScreen));
            holder.mViewOperator.setTextColor(mContext.getColor(R.color.GBScreen));
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
                        mFullGB.addBreakpoint(position);
                    } else {
                        mFullGB.clearBreakpoint(position);
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
