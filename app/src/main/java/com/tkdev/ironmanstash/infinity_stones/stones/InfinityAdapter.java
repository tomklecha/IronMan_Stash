package com.tkdev.ironmanstash.infinity_stones.stones;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tkdev.ironmanstash.R;

import java.util.ArrayList;
import java.util.List;

public class InfinityAdapter extends RecyclerView.Adapter<InfinityAdapter.InfinityViewHolder> {

    private Context context;
    private List<InfinityStone> infinityStones;

    public InfinityAdapter(Context context, List<InfinityStone> infinityStones) {
        this.context = context;
        this.infinityStones = infinityStones;
    }

    @Override
    public InfinityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new InfinityViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_infinity_content, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(InfinityViewHolder infinityViewHolder, int position) {
//        if (infinityStones.get(position).isVisible() == View.VISIBLE) {
        infinityViewHolder.stoneImageView.setImageResource(infinityStones.get(position).getImageId());
//        } else {
//            infinityViewHolder.stoneImageView.setVisibility(View.INVISIBLE);
//        }
        infinityViewHolder.stoneTextView.setText(infinityStones.get(position).getStoneName());
    }

    @Override
    public int getItemCount() {
        return infinityStones.size();
    }

    public class InfinityViewHolder extends RecyclerView.ViewHolder {

        private ImageView stoneImageView;
        private TextView stoneTextView;

        public InfinityViewHolder(View view) {
            super(view);
            stoneImageView = view.findViewById(R.id.recycler_stone_image);

            stoneTextView = view.findViewById(R.id.recycler_stone_name);
            stoneTextView.setText(R.string.power_stone_quest);
        }
    }
}

