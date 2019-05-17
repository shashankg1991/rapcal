package com.spectra.rapcal.persistence.dao;

import com.spectra.rapcal.persistence.entity.Rap;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface RapDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addRap(Rap rap);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Rap> raps);

    @Query("SELECT * FROM raps order by fromWeight,toWeight,color")
    public List<Rap> findAllRaps();

    @Query("SELECT * FROM raps where id =:id")
    public Rap findRapById(Integer id);

    @Query("DELETE from raps where id = :id")
    public void deleteRap(Integer id);

    @Query("DELETE from raps")
    public void deleteAllRaps();

    @Query("SELECT * FROM raps WHERE color = :color and purity = :purity and shape= :shape and fromWeight = :lowerLimit and toWeight = :upperLimit")
    public List<Rap> findRap(String color, String purity, String shape, double lowerLimit, double upperLimit);

    @Query("SELECT * FROM raps WHERE color = :color and purity = :purity and shape= :shape and fromWeight <= :weight and toWeight >= :weight")
    public Rap findRap(String color, String purity, String shape, double weight);

    @Query("UPDATE  raps set color = :color and purity = :purity and shape= :shape and fromWeight = :lowerLimit and toWeight = :upperLimit WHERE id= :id ")
    public void updateRap(Integer id, String color, String purity, String shape, double lowerLimit, double upperLimit);
}
