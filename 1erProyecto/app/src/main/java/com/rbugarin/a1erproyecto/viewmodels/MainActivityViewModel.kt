package com.rbugarin.a1erproyecto.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.liveData
import com.rbugarin.a1erproyecto.models.entities.Registro
import com.rbugarin.a1erproyecto.models.roomdb.RegistroDB
import com.rbugarin.a1erproyecto.repositories.RegistroRepository

class MainActivityViewModel (application : Application) : AndroidViewModel(application){

    private val registroRepository = RegistroRepository(application)

    fun getRegistros(): LiveData<List<Registro>> = liveData {
        val registros = registroRepository.getAllRegistros()

        emit(registros)
    }
}