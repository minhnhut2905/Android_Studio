package com.example.appbookinghotel.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.appbookinghotel.Detail_Hotel_Activity;
import com.example.appbookinghotel.Domain.HotelDomain;
import com.example.appbookinghotel.R;

import java.util.ArrayList;

public class HotelListAdapter extends RecyclerView.Adapter<HotelListAdapter.ViewHoder> {
    ArrayList<HotelDomain> items;
    Context context;
    public HotelListAdapter(ArrayList<HotelDomain> items){
        this.items = items;
    }
    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhoder_hotel_list,parent,false);
        context=parent.getContext();
        return new ViewHoder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.time.setText(items.get(position).getTime() +"min");
        holder.score.setText(""+items.get(position).getScore());
        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30,30,0,0))
                .into(holder.picAnh);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), Detail_Hotel_Activity.class);
                intent.putExtra("object",items.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder{
        TextView title, time,score;
        ImageView picAnh;
        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titletxt);
            time = itemView.findViewById(R.id.timetxt);
            score = itemView.findViewById(R.id.scoretxt);
            picAnh = itemView.findViewById(R.id.picAnh);
        }
    }
}
