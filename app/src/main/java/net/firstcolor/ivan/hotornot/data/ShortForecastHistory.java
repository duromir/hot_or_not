package net.firstcolor.ivan.hotornot.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Room;
import android.content.Context;

import net.firstcolor.ivan.hotornot.models.helper_models.Forecast;
import net.firstcolor.ivan.hotornot.models.helper_models.ShortForecast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Entity(tableName = "short_forecasts")
public class ShortForecastHistory {

    @PrimaryKey
    private int id;

    @ColumnInfo(name="dateTime")
    private String dateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @ColumnInfo(name="short_description")
    private String shortDescription;

    @ColumnInfo(name="long_description")
    private String longDescription;

    @ColumnInfo(name="temperature")
    private int temperature;

    public ShortForecastHistory(){

    }

    private ShortForecastHistory(String shortDescription, String longDescription, int temperature){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        this.dateTime = formatter.format(new Date());
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.temperature = temperature;
    }

    private static ShortForecastHistory createNew(String shortDescription, String longDescription, int temperature){
        return new ShortForecastHistory(shortDescription, longDescription, temperature);
    }

    public static void createByShortForecasts(Context context, List<ShortForecast> forecasts) {
        List<ShortForecastHistory> history = new ArrayList<ShortForecastHistory>();
        for(ShortForecast forecast: forecasts){
            history.add(
                createNew(
                    forecast.getWeatherShortDescription(),
                    forecast.getWeatherLongDescription(),
                    (int)(forecast.getTemperature())
                )
            );
        }
        AppDatabase db = Room.databaseBuilder(context,
                AppDatabase.class, "forecast_history").build();
        db.shortForecastHistoryDao().insertAll(history);
    }
}
