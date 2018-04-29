package net.firstcolor.ivan.hotornot.services;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.firstcolor.ivan.hotornot.models.HourlyForecast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HourlyForecastController implements Callback<HourlyForecast> {

    private OnSuccessCallback callback;

    public void start(Location location, OnSuccessCallback onSuccessCallback){
        callback = onSuccessCallback;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(WeatherService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        WeatherService service = retrofit.create(WeatherService.class);
        Call<HourlyForecast> call = service.getHourlyForecast(location.getLatitude(), location.getLongitude(), WeatherService.APP_ID);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<HourlyForecast> call, Response<HourlyForecast> response) {
        try{
            callback.handleHourlyForecast(response.body());
        }
        catch (NullPointerException ex) {
            Log.d("TAG", "response.body is null");
        }
    }

    @Override
    public void onFailure(Call<HourlyForecast> call, Throwable t) {

    }

    public interface OnSuccessCallback{
        void handleHourlyForecast(HourlyForecast forecast);
    }
}
