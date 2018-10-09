package org.it.spu.fitness;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ContactsApi {
    @GET("/api/1.0/filiation")
    Observable<GetContacstResponse> getContacts();
}