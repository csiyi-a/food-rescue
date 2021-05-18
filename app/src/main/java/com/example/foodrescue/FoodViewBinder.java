package com.example.foodrescue;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.greendao.db.bean.Food;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import me.drakeet.multitype.ItemViewBinder;

public class FoodViewBinder extends ItemViewBinder<Food, FoodViewBinder.UIViewHolder> {


    private OnItemClick onItemClick;

    public FoodViewBinder(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    protected UIViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_food, parent, false);
        return new UIViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull UIViewHolder holder, @NonNull Food item) {

        holder.name.setText(item.getTitle());
        holder.desc.setText(item.getDesc());

        Bitmap bitmap = BitmapFactory.decodeFile(item.getImgUrl());

        if (bitmap==null){
            holder.image.setImageResource(R.mipmap.ic_launcher);
        }else{
            holder.image.setImageBitmap(bitmap);
        }

        holder.itemView.setOnClickListener(v -> onItemClick.onItem(item));
        holder.collect.setOnClickListener(v -> onItemClick.onShareItem(getPosition(holder),item));
    }


    public static class UIViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.collect)
        ImageView collect;

        UIViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);

        }
    }


    public interface OnItemClick {
        void onItem(Food item);
        void onShareItem(int position,Food item);
    }
}
