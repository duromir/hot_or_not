package net.firstcolor.ivan.hotornot.services;

import net.firstcolor.ivan.hotornot.models.HourlyForecast;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {

    public static final String APP_ID = "6803d5af013e7c7e179bfa176b89b2fe";
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    @GET("forecast?cnt=10&units=metric")
    Call<HourlyForecast> getHourlyForecast(
            @Query("lat") double latitude,
            @Query("lon") double longtitude,
            @Query("APPID") String weatherAppId
    );
}
