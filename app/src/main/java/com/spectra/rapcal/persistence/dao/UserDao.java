package com.spectra.rapcal.persistence.dao;


import com.spectra.rapcal.persistence.entity.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addUser(User user);

    @Query("SELECT * FROM users WHERE username = :username")
    public List<User> findUserWithUserName(String username);

    @Query("DELETE FROM users")
    public void truncateTable();
}
