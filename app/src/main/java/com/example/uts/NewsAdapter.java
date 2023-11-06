package com.example.uts;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private Context context;

    public static Vector<News> news = new Vector<>();

    public NewsAdapter(Context context) {
        this.context = context;
    }

    public static void setNews(Vector<News> news) {
        NewsAdapter.news = news;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        holder.newsTitle.setText(news.get(position).getNewsTitle());
        holder.newsDescription.setText(news.get(position).getNewsDescription());
        holder.image.setImageResource(news.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView newsTitle, newsDescription;
        ImageView image;

        CardView click;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            newsTitle = itemView.findViewById(R.id.newsTitle);
            newsDescription = itemView.findViewById(R.id.newsDescription);
            image =itemView.findViewById(R.id.newsImage);
            click = (CardView) itemView.findViewById(R.id.newsCV);
            click.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Intent detail = new Intent(v.getContext(), NewsDetail.class);

            detail.putExtra("image", news.get(getAdapterPosition()).getImage());
            detail.putExtra("title", news.get(getAdapterPosition()).getNewsTitle());
            detail.putExtra("content", news.get(getAdapterPosition()).getNewsContent());

            context.startActivity(detail);


        }
    }
}
