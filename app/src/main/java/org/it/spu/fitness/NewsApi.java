package org.it.spu.fitness;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("/api/1.0/shared/news")
    Observable<GetNewsResponse> getNews();
}
