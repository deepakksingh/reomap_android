package com.example.reomap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListDataAdapter extends RecyclerView.Adapter<ListDataAdapter.ViewHolder> {
    List<ListItemData> listItems;
    private Context context;

    public ListDataAdapter(List<ListItemData> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ListItemData listItemData = listItems.get(position);
        holder.tvHead.setText(listItemData.getHead());
        holder.tvDesc.setText(listItemData.getDesc());

        Picasso.get()
                .load(listItemData.getImageUrl())
                .into(holder.ivImg);

        holder.linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked on "+ listItemData.getHead(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvHead;
        public TextView tvDesc;
        public ImageView ivImg;
        public LinearLayout linearLayout1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvHead = (TextView)itemView.findViewById(R.id.tvHeading);
            tvDesc = (TextView)itemView.findViewById(R.id.tvDescription);
            ivImg = (ImageView)itemView.findViewById(R.id.ivImg);
            linearLayout1 = (LinearLayout) itemView.findViewById(R.id.linearLayout1);


        }
    }
}

