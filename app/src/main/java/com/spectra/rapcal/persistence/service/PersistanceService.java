package com.spectra.rapcal.persistence.service;

import android.app.Application;
import android.content.Context;

import com.spectra.rapcal.persistence.RapCalDB;
import com.spectra.rapcal.persistence.entity.Rap;

import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import static com.spectra.rapcal.constants.RapCalConstants.RAPCAL_DB;

public class PersistanceService extends Application {
    private static RapCalDB rapCalDB;
    private static PersistanceService persistanceService = null;
    private static Context context;

    private PersistanceService() {
    }

    public static PersistanceService initialize(Context contextValue) {
        if (null == persistanceService) {
            persistanceService = new PersistanceService();
        }
        context = contextValue;
        rapCalDB = Room.databaseBuilder(context, RapCalDB.class, RAPCAL_DB).addCallback(new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        getInstance().getDb().rapDao().insertAll(Rap.populateRaps());
                    }
                });
            }
        }).allowMainThreadQueries().build();
        return persistanceService;
    }

    public static PersistanceService getInstance() {
        if (null == persistanceService) {
            throw new RuntimeException("Persistance service has not been initialized");
        }
        return persistanceService;
    }

    public RapCalDB getDb() {
        return getInstance().rapCalDB;
    }
}
