package com.rbugarin.a1erproyecto.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.rbugarin.a1erproyecto.models.entities.Registro
import com.rbugarin.a1erproyecto.repositories.RegistroRepository
import kotlinx.coroutines.launch

class ActivityAddRegistroViewModel (application: Application) : AndroidViewModel(application) {
    private val registroRepository = RegistroRepository(application)
    private val TAG = ActivityAddRegistroViewModel::class.java.name
    private val insertLiveData = MutableLiveData<Boolean>()

    fun insertRegistro(registro: Registro) = viewModelScope.launch {
        try {
            registroRepository.insertRegistro(registro)
            insertLiveData.postValue(true)
        } catch (ex: Exception) {
            Log.e(TAG, ex.message, ex)
            insertLiveData.postValue(false)
        }
    }

    fun notifyInsertRegistro() : LiveData<Boolean> = insertLiveData

    fun getAllContent() : LiveData<List<Registro>> = liveData {
        emit(registroRepository.getAllRegistros())
    }
}