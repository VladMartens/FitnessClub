package org.it.spu.fitness;

import android.app.Application;
import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FitnessApp extends Application {
    Retrofit retrofit = null;


    public static FitnessApp get(Context ctx) {
        return (FitnessApp) ctx.getApplicationContext();
    }

    public Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.2.126.20:8080")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
