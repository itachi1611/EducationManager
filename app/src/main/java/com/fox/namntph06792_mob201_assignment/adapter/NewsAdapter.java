package com.fox.namntph06792_mob201_assignment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fox.namntph06792_mob201_assignment.R;
import com.fox.namntph06792_mob201_assignment.activity.WebActivity;
import com.fox.namntph06792_mob201_assignment.model.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    public Context context;
    public List<News> lvNews;

    public NewsAdapter(Context context, List<News> lvNews) {
        this.context = context;
        this.lvNews = lvNews;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news,viewGroup,false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsHolder newsHolder, int i) {
        newsHolder.news = lvNews.get(i);
        newsHolder.tvTitle.setText(newsHolder.news.title);
        newsHolder.tvDescription.setText(newsHolder.news.description);
        newsHolder.tvPubDate.setText(newsHolder.news.pubDate);
        newsHolder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("link",newsHolder.news.link);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (lvNews == null) ? 0 : lvNews.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder{

        private TextView tvTitle;
        private TextView tvDescription;
        private TextView tvPubDate;
        News news;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvPubDate = itemView.findViewById(R.id.tvPubDate);
        }
    }
}
