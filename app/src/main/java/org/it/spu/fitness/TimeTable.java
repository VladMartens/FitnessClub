package org.it.spu.fitness;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TimeTable extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    Toolbar toolbar;
    TimeTableApi timeTableApi;

    void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Расписание");
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

    @SuppressLint("CheckResult")
    void GetTimeTable() {
        timeTableApi.getTimeTable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe((GetTimeTableResponse response) -> {
                    for (int i = 0; i < response.getData().size(); i++) {
                        timeTableParses.add(new TimeTableParse(
                                response.getData().get(i).getDay().getNameDay(),
                                response.getData().get(i).getStarttime(),
                                response.getData().get(i).getScheduleEvent().getName(),
                                response.getData().get(i).getScheduleEvent().getDescription()));
                    }
                    adapterTable.setTimeTableParses(timeTableParses);
                });
    }

    RecyclerView recyclerView;
    TimetableAdapter adapterTable;
    List<TimeTableParse> timeTableParses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timetable);
        initDrawerandNav();
        initToolbar();

        timeTableApi = FitnessApp.get(this).getRetrofit().create(TimeTableApi.class);
        GetTimeTable();
        adapterTable = new TimetableAdapter(timeTableParses, this);

        recyclerView = findViewById(R.id.recycler);

        GridLayoutManager gml = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gml);
        recyclerView.setAdapter(adapterTable);
    }
}