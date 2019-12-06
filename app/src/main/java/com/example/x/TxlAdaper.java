package com.example.x;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TxlAdaper extends RecyclerView.Adapter
        <TxlAdaper.ViewHolder> {
    private List<Txl> mTxlList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View txlView;
        ImageView txlImage;
        TextView txlName;
        TextView phoneNumber;

        public ViewHolder(View view) {
            super(view);
            txlView = view;
            txlImage = (ImageView) view.findViewById(R.id.txl_image);
            txlName = (TextView) view.findViewById(R.id.txl_name);
            phoneNumber = (TextView) view.findViewById(R.id.phone_1);
        }
    }

    public TxlAdaper(List<Txl> txlList) {
        mTxlList = txlList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.txl_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.txlName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Txl txl = mTxlList.get(position);
                Toast.makeText(v.getContext(), "你点击了" + txl.getName() + "的名字",
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.txlImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Txl txl = mTxlList.get(position);
                Toast.makeText(view.getContext(), "你点击了" + txl.getName() + "脑袋儿~",
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Txl txl = mTxlList.get(position);
                Toast.makeText(v.getContext(), "你点击了" + txl.getName() + "电话",
                        Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Txl txl = mTxlList.get(position);
        holder.txlImage.setImageResource(txl.getImageId());
        holder.txlName.setText(txl.getName());
        holder.phoneNumber.setText(txl.getPhone());
    }

    @Override
    public int getItemCount() {
        return mTxlList.size();
    }
}