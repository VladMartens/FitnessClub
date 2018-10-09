package org.it.spu.fitness;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private List<ConractParse> conractParses;
    private Context ctx;

    public void setClickHandler(MyClickHandler clickHandler) {
        this.clickHandler = clickHandler;
    }

    private MyClickHandler clickHandler;

    public interface MyClickHandler {
        void onClick(ConractParse conractParse);
    }

    ContactAdapter(List<ConractParse> conractParses, Context ctx) {
        this.conractParses = conractParses;
        this.ctx = ctx;
    }

    public void setContactParses(List<ConractParse> conractParse) {
        this.conractParses = conractParse;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.contacts_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(conractParses.get(position));
    }

    @Override
    public int getItemCount() {
        return conractParses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView caption;
        TextView country;
        TextView indexcity;
        TextView citi;
        TextView adress;
        TextView phone1;
        TextView phone2;
        TextView email;

        ViewHolder(View itemView) {
            super(itemView);
            caption = itemView.findViewById(R.id.caption);
            country = itemView.findViewById(R.id.country);
            indexcity = itemView.findViewById(R.id.indexcity);
            citi = itemView.findViewById(R.id.citi);
            adress = itemView.findViewById(R.id.adress);
            phone1 = itemView.findViewById(R.id.phone1);
            phone2 = itemView.findViewById(R.id.phone2);
            email = itemView.findViewById(R.id.email);
        }

        @SuppressLint("SetTextI18n")
        void bind(final ConractParse conractParse) {
            caption.setText(conractParse.getCaption());
            country.setText(conractParse.getCountry());
            indexcity.setText(conractParse.getIndexCity());
            citi.setText(conractParse.getCity());
            adress.setText(conractParse.getStreet() + " " + conractParse.getNum_b());
            phone1.setText(conractParse.getPhone1());
            phone2.setText(conractParse.getPhine2());
            email.setText(conractParse.getEmail());

            itemView.setOnClickListener(v -> {
                if (clickHandler != null) clickHandler.onClick(conractParse);
            });

        }
    }
}

