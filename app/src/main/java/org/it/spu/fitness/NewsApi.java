package org.it.spu.fitness;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("/api/1.0/news")
    Observable<GetNewsResponse> getNews();
}
