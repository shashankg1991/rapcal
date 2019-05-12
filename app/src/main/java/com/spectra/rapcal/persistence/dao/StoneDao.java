package com.spectra.rapcal.persistence.dao;

import com.spectra.rapcal.persistence.entity.Stone;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface StoneDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addStone(Stone stone);

    @Query("SELECT * FROM stones")
    public List<Stone> findAllStones();

    @Query("SELECT * FROM stones where id =:id")
    public Stone findStoneById(Integer id);

    @Query("DELETE from stones where id = :id")
    public void deleteStone(Integer id);

}
