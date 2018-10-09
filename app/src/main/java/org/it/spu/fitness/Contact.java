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

public class Contact extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    Toolbar toolbar;

    void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Контакты");
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
    ContactAdapter adapter;
    ContactsApi contactsApi;
    Intent intent;
    List<ConractParse> conractParses = new ArrayList<>();

    @SuppressLint("CheckResult")
    void GetContacts() {
        contactsApi.getContacts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe((GetContacstResponse response) -> {
                    for (int i = 0; i < response.getData().size(); i++) {
                        conractParses.add(new ConractParse(
                                response.getData().get(i).getCaption(),
                                response.getData().get(i).getCountry(),
                                response.getData().get(i).getIndexCity(),
                                response.getData().get(i).getCity(),
                                response.getData().get(i).getStreet(),
                                response.getData().get(i).getBuilding(),
                                response.getData().get(i).getContacts().get(0).getData(),
                                response.getData().get(i).getContacts().get(1).getData(),
                                response.getData().get(i).getContacts().get(2).getData()));
                    }
                    adapter.setContactParses(conractParses);
                }, Throwable::printStackTrace);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        initDrawerandNav();
        initToolbar();

        contactsApi = FitnessApp.get(this).getRetrofit().create(ContactsApi.class);
        GetContacts();

        adapter = new ContactAdapter(conractParses, this);

        intent = new Intent(this, Contact.class);

        recyclerView = findViewById(R.id.recycler);

        GridLayoutManager gml = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gml);
        recyclerView.setAdapter(adapter);
    }
}