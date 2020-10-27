package com.rbugarin.a1erproyecto.models.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rbugarin.a1erproyecto.models.entities.Registro
import com.rbugarin.a1erproyecto.models.dao.ResgistroDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@Database(
    entities = [Registro::class],
    version = 1,
    exportSchema = true
)

abstract class RegistroDB : RoomDatabase() {
    abstract fun regitroDAO(): ResgistroDAO

    companion object{

        @Synchronized
        fun getInstance(context: Context): RegistroDB{
            if(instance==null){
                instance = Room.databaseBuilder(
                    context,
                    RegistroDB::class.java,
                    "registo.db"
                    ).fallbackToDestructiveMigration()
                    .build()

                CoroutineScope(Dispatchers.IO).launch {
                    instance?.initDB()
                }
            }
            return instance as RegistroDB
        }
    }
    suspend fun initDB(){
        val registroDAO = regitroDAO()
        if (registroDAO.getAllRegistrosSync().isEmpty()){
        registroDAO.insertRegistro(
            Registro(
            null,
            "Ramon",
            "Bugarin",
            "buga_117@hotmail.com",
            "Adoptar",
            "Gato"
            )
        )
        }
    }
}
@Volatile
private var instance: RegistroDB?=null