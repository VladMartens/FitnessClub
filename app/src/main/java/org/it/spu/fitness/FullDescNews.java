package org.it.spu.fitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class FullDescNews extends AppCompatActivity {

    ImageView imageView;
    TextView title;
    TextView desc;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_desc_news);

        imageView = findViewById(R.id.image);
        title = findViewById(R.id.title);
        desc = findViewById(R.id.desc);
        date = findViewById(R.id.date);

        Intent intent = getIntent();

        Picasso.with(this)
                .load(intent.getStringExtra("url"))
                .error(R.drawable.ic_launcher_background)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
        title.setText(intent.getStringExtra("title"));
        desc.setText(intent.getStringExtra("desc"));
        date.setText(intent.getStringExtra("date"));
    }
}
