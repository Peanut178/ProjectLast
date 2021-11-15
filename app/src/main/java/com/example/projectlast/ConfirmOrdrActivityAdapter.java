package com.example.projectlast;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ConfirmOrdrActivityAdapter extends RecyclerView.Adapter<ConfirmOrdrActivityAdapter.ConfirmOrderViewHolder>{

    private ArrayList<OrderListModel>orderListModels;
    Activity activity;

    public ConfirmOrdrActivityAdapter(Activity activity){
        this.activity = activity;
        orderListModels = ((UpdateSelectedItems)ApplicationMain.getMycontext()).getItems();
    }
    @NonNull
    @Override
    public ConfirmOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item,parent,false);
        ConfirmOrderViewHolder confirmOrderViewHolder = new ConfirmOrderViewHolder(view);
        return confirmOrderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ConfirmOrderViewHolder holder, int position) {

        OrderListModel currentItem = orderListModels.get(position);
        holder.name.setText(currentItem.getName());
    }

    @Override
    public int getItemCount() {
       return orderListModels.size();
    }

    public class ConfirmOrderViewHolder extends RecyclerView.ViewHolder {
        TextView name,price;
        public ConfirmOrderViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.namesp);
            price = itemView.findViewById(R.id.price);
        }
    }
}
