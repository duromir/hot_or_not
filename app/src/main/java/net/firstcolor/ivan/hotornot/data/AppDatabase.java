package net.firstcolor.ivan.hotornot.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ShortForecastHistory.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract ShortForecastHistoryDao shortForecastHistoryDao();
}
