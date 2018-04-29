package net.firstcolor.ivan.hotornot.models;

import net.firstcolor.ivan.hotornot.models.helper_models.LocationInfo;
import java.util.List;

public class DailyForecast implements Forecast {

    private LocationInfo city;
    private List<Forecast> list;

    public String getLocationName() {
        return city.name;
    }

    public Forecast getForecastForDay(int dayIndex) {
        return list.get(dayIndex);
    }
}
