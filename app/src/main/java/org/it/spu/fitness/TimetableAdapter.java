package org.it.spu.fitness;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TimetableAdapter extends RecyclerView.Adapter<TimetableAdapter.ViewHolder> {
    private List<TimeTableParse> timeTableParses;
    private Context ctx;

    public void setClickHandler(MyClickHandler clickHandler) {
        this.clickHandler = clickHandler;
    }

    private MyClickHandler clickHandler;

    public interface MyClickHandler {
        void onClick(TimeTableParse timeTableParse);
    }

    TimetableAdapter(List<TimeTableParse> timeTableParses, Context ctx) {
        this.timeTableParses = timeTableParses;
        this.ctx = ctx;
    }

    public void setTimeTableParses(List<TimeTableParse> timeTableParses) {
        this.timeTableParses = timeTableParses;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TimetableAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.timetable_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(timeTableParses.get(position));
    }

    @Override
    public int getItemCount() {
        return timeTableParses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView day;
        TextView startTime;
        TextView eventName;
        TextView description;

        ViewHolder(View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.day);
            startTime = itemView.findViewById(R.id.starttime);
            eventName = itemView.findViewById(R.id.evantname);
            description = itemView.findViewById(R.id.description);
        }

        void bind(final TimeTableParse timeTableParse) {
            day.setText(timeTableParse.getNameDay());
            startTime.setText(timeTableParse.getStartTime());
            eventName.setText(timeTableParse.getEventName());
            description.setText(timeTableParse.getDescription());
            itemView.setOnClickListener(v -> {
                if (clickHandler != null) clickHandler.onClick(timeTableParse);
            });
        }
    }

}
