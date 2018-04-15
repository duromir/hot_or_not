package net.firstcolor.ivan.hotornot.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ShortForecastHistoryDao {

    @Query("SELECT * FROM short_forecasts")
    List<ShortForecastHistory> getAll();

    @Insert
    void insertAll(List<ShortForecastHistory> shortForecastHistories);
}
