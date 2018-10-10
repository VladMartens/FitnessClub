package org.it.spu.fitness;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<NewsParse> newsParses;
    private Context ctx;

    public void setClickHandler(MyClickHandler clickHandler) {
        this.clickHandler = clickHandler;
    }

    private MyClickHandler clickHandler;

    public interface MyClickHandler {
        void onClick(NewsParse newsParse);
    }


    NewsAdapter(List<NewsParse> newsParses, Context ctx) {
        this.newsParses = newsParses;
        this.ctx = ctx;
    }

    public void setNewsParses(List<NewsParse> newsParses) {
        this.newsParses = newsParses;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.news_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        holder.bind(newsParses.get(position));
    }

    @Override
    public int getItemCount() {
        return newsParses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView dateTextView;
CardView cardView;
        ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleView);
            dateTextView = itemView.findViewById(R.id.dateView);
            cardView = itemView.findViewById(R.id.Card);
        }

        void bind(final NewsParse newsParse) {
            titleTextView.setText(newsParse.getTitle());
            dateTextView.setText(newsParse.getDate());
            itemView.setOnClickListener(v -> {
                if (clickHandler != null) clickHandler.onClick(newsParse);
            });
        }
    }
}
