package com.tkdev.ironmanstash.infinity_stones.fragments.allstones;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tkdev.ironmanstash.R;

import java.util.List;

public class InfinityAdapter extends RecyclerView.Adapter<InfinityAdapter.InfinityViewHolder> {

    private int IS_VISIBLE = 4;
    private Context context;
    private List<InfinityStone> infinityStones;

    public InfinityAdapter(Context context, List<InfinityStone> infinityStones) {
        this.context = context;
        this.infinityStones = infinityStones;
    }

    @Override
    public InfinityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new InfinityViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_container, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(InfinityViewHolder infinityViewHolder, int position) {
        infinityViewHolder.stoneImageView.setImageResource(infinityStones.get(position).getImageId());
        if (infinityStones.get(position).getIsVisible() == IS_VISIBLE) {
            infinityViewHolder.stoneImageView.setImageAlpha(30);
        }
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

    public void setList(List<InfinityStone> list) {
        this.infinityStones = list;
    }
}
// CURSOR adapter

//public class InfinityCursorAdapter extends RecyclerView.Adapter<InfinityCursorAdapter.InfinityViewHolder> {
//
//    private Context context;
//    private Cursor cursor;
//
//    public InfinityCursorAdapter(Context context, Cursor cursor) {
//        this.context = context;
//        this.cursor = cursor;
//    }
//
//    @Override
//    public InfinityViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        return new InfinityViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_container, viewGroup, false));
//    }
//
//    @Override
//    public void onBindViewHolder(InfinityViewHolder infinityViewHolder, int position) {
//        if (cursor.moveToPosition(position)) {
//            infinityViewHolder.stoneImageView.setImageResource(cursor.getInt(2));
//            if (cursor.getInt(3) == View.INVISIBLE) {
//                infinityViewHolder.stoneImageView.setImageAlpha(30);
//            }
//
//        }
//        infinityViewHolder.stoneTextView.setText(cursor.getString(1));
//    }
//
//    @Override
//    public int getItemCount() {
//        return cursor.getCount();
//    }
//
//    public class InfinityViewHolder extends RecyclerView.ViewHolder {
//
//        private ImageView stoneImageView;
//        private TextView stoneTextView;
//
//        public InfinityViewHolder(View view) {
//            super(view);
//            stoneImageView = view.findViewById(R.id.recycler_stone_image);
//
//            stoneTextView = view.findViewById(R.id.recycler_stone_name);
//        }
//    }
//}
//
