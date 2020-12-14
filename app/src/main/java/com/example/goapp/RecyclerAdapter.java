package com.example.goapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    List<RecycleClass> recycleClasses1;
    Context context;
    public RecyclerAdapter(List<RecycleClass> recycleClasses,Context context)
    {
        this.context=context;
        this.recycleClasses1=recycleClasses;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cartyp,parent,false);
        RecyclerViewHolder viewHolder=new RecyclerViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder holder, final int position) {
        final RecycleClass recycleClass=recycleClasses1.get(position);
        holder.textView.setText(recycleClass.getText());
        holder.textView1.setText("Price ="+recycleClass.getPrice());
        holder.imageView.setImageResource(recycleClass.getImage());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent();
                RecycleClass recycleClass2=recycleClasses1.get(position);
                intent = new Intent(context, CheckoutPage.class);

                intent.putExtra("image",recycleClass2.getImage());
                intent.putExtra("name",recycleClass2.getText());
                intent.putExtra("price",recycleClass2.getPrice());
                context.startActivities(new Intent[]{intent});
            }

        });
    }
    @Override
    public int getItemCount() {
        return recycleClasses1.size();
    }
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,textView1;
        RelativeLayout relativeLayout;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            textView=itemView.findViewById(R.id.textView);
            textView1=itemView.findViewById(R.id.price);
            relativeLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}

