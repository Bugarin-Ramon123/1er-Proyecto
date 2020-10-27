package com.rbugarin.a1erproyecto.models.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rbugarin.a1erproyecto.models.entities.Registro

@Dao
abstract class ResgistroDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insertRegistro(registro: Registro)

    @Query("SELECT * FROM Registro")
    abstract fun getAllRegistro(): LiveData<List<Registro>>

    @Query("SELECT * FROM Registro")
    abstract suspend fun getAllRegistrosSync() : List<Registro>
}