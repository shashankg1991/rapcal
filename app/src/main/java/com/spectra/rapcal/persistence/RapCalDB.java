package com.spectra.rapcal.persistence;

import com.spectra.rapcal.persistence.dao.RapDao;
import com.spectra.rapcal.persistence.dao.StoneDao;
import com.spectra.rapcal.persistence.dao.UserDao;
import com.spectra.rapcal.persistence.entity.Rap;
import com.spectra.rapcal.persistence.entity.Stone;
import com.spectra.rapcal.persistence.entity.User;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Rap.class,Stone.class}, version = 1)
public abstract class RapCalDB extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract RapDao rapDao();
    public abstract StoneDao stoneDao();
}
