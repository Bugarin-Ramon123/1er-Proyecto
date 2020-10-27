package com.rbugarin.a1erproyecto.repositories

import android.content.Context
import com.rbugarin.a1erproyecto.models.entities.Registro
import com.rbugarin.a1erproyecto.models.roomdb.RegistroDB

class RegistroRepository (context: Context) {

    private val registroDB = RegistroDB.getInstance(context)
    private val registroDAO = registroDB.regitroDAO()

    suspend fun insertRegistro(registro: Registro){
        registroDAO.insertRegistro(registro)
    }

    suspend fun getAllRegistros() : List<Registro>{
        return registroDAO.getAllRegistrosSync()
    }
}