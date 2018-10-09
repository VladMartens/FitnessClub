package org.it.spu.fitness;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface TimeTableApi {
    @GET("/api/v1/schedules")
    Observable<GetTimeTableResponse> getTimeTable();
}