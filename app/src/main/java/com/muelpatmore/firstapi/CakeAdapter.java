package com.muelpatmore.firstapi;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.muelpatmore.firstapi.util.constants.CakeModel;

import java.util.ArrayList;

public class CakeAdapter extends RecyclerView.Adapter<CakeAdapter.MyViewHolder> {

    private ArrayList<CakeModel> realmCustomers;
    private int row_cake;
    private Context applicationContext;

    public CakeAdapter(ArrayList<CakeModel> realmCustomers, int row_customer, Context applicationContext) {
        this.realmCustomers = realmCustomers;
        this.row_cake = row_customer;
        this.applicationContext = applicationContext;
    }

    // creates views
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // get layout taht si passed from from app comtext
        // inflate row from this context, from thsi parent in this pattern
        View view = LayoutInflater.from(applicationContext).inflate(R.layout.cake_item, parent, false);

        //viewholder init view elements and is then passed back
        return new MyViewHolder(view);
    }

    // binds data to view
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // collect data from Realm item and plug into View
        holder.tvTitle.setText(realmCustomers.get(position).getTitle().toString());
        holder.tvDescription.setText(realmCustomers.get(position).getDesc().toString());

        //holder.ivImage.setImageBitmap();
    }

    @Override
    public int getItemCount() {
        return realmCustomers.size();
    }

    // inits row elements
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription;
        ImageView ivImage;
        public MyViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);

        }
    }
}

