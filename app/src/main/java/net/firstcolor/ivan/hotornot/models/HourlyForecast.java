package net.firstcolor.ivan.hotornot.models;


import net.firstcolor.ivan.hotornot.models.helper_models.LocationInfo;
import net.firstcolor.ivan.hotornot.models.helper_models.ShortForecast;

import java.util.List;

public class HourlyForecast implements Forecast {

    /**
     * empty constructor
     */
    public HourlyForecast(){}

    private LocationInfo city;
    private List<ShortForecast> list;

    public String getLocationName() {
        return city.name;
    }

    public List<ShortForecast> getForecasts() {
        return list;
    }
}
