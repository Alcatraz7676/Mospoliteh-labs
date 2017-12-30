package com.maxovch.laba_3.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maxovch.laba_3.OnGenreClickListener;
import com.maxovch.laba_3.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GenresAdapter extends RecyclerView.Adapter<GenresAdapter.ViewHolder> {

    private OnGenreClickListener clickListener;

    public GenresAdapter(OnGenreClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.genre.setText("Комедия");
                holder.setOnClickListener(0);
                return;
            case 1:
                holder.genre.setText("Драма");
                holder.setOnClickListener(1);
                return;
            case 2:
                holder.genre.setText("Мультфильм");
                holder.setOnClickListener(2);
                return;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.genre_name)
        TextView genre;

        private View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            ButterKnife.bind(this, view);
        }

        public void setOnClickListener(final int genreId) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickListener.onItemClick(genreId);
                }
            });
        }
    }
}