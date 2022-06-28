package com.app.proyectot4.api;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;

public class EqApiClient {
    public interface EqService {
        @GET("filter.php?c=Ordinary_Drink")
        Call<CategoriaJSONResponse> getCategorias();
    }
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build();

    private EqService service;

    private static final EqApiClient ourInstance = new EqApiClient();

    public static EqApiClient getInstance(){
        return ourInstance;
    }
    private EqApiClient(){

    }
    public EqService getService(){
        if(service==null){
            service=retrofit.create(EqService.class);
        }
        return service;
    }

}
