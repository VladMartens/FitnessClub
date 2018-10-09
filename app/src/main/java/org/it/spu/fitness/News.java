package org.it.spu.fitness;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class News extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    Toolbar toolbar;

    void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Новости");
    }

    void initDrawerandNav() {
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        final Intent news = new Intent(this, News.class);
        final Intent contact = new Intent(this, Contact.class);
        final Intent timetable = new Intent(this, TimeTable.class);

        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.News) {
                startActivity(news);
            } else if (item.getItemId() == R.id.Contact) {
                startActivity(contact);
            } else if (item.getItemId() == R.id.TimeTable) {
                startActivity(timetable);
            }

            item.setChecked(true);
            if (drawerLayout.isDrawerOpen(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    RecyclerView recyclerView;
    NewsAdapter adapter;
    Intent intent;
    NewsApi newsApi;
    List<NewsParse> news = new ArrayList<>();

    @SuppressLint("CheckResult")
    void GetNews() {
        newsApi.getNews().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe((GetNewsResponse response) -> {
                    for (int i = 0; i < response.getData().size(); i++) {
                        news.add(new NewsParse(
                                response.getData().get(i).getTitle(),
                                response.getData().get(i).getDate(),
                                response.getData().get(i).getDescription(),
                                response.getData().get(i).getImageURL()));
                    }
                    adapter.setNewsParses(news);
                }, Throwable::printStackTrace);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        initDrawerandNav();
        initToolbar();

        newsApi = FitnessApp.get(this).getRetrofit().create(NewsApi.class);
        GetNews();

        adapter = new NewsAdapter(news, this);

        intent = new Intent(this, FullDescNews.class);

        adapter.setClickHandler(newsParse -> {
            intent.putExtra("url", newsParse.getUrl_photo());
            intent.putExtra("title", newsParse.getTitle());
            intent.putExtra("desc", newsParse.getDescription());
            intent.putExtra("date", newsParse.getDate());
            startActivity(intent);
        });

        recyclerView = findViewById(R.id.recycler);

        GridLayoutManager gml = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gml);
        recyclerView.setAdapter(adapter);
    }
}
