package org.it.spu.fitness;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface TimeTableApi {
    @GET("/api/1.0/shared/schedules")
    Observable<GetTimeTableResponse> getTimeTable();
}