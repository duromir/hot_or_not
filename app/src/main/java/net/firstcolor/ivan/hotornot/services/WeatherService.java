package net.firstcolor.ivan.hotornot.services;

import net.firstcolor.ivan.hotornot.models.HourlyForecast;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherService {

    public static final String APPID = "6803d5af013e7c7e179bfa176b89b2fe";
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    @GET("forecast?lat={lat}&lon={lon}&APPID={app_id}&cnt=10&units=metric ")
    HourlyForecast getHourlyForecast(
            @Path("lat") double latitude,
            @Path("lon") double longtitude,
            @Path("app_id") String weatherAppId
    );
}
