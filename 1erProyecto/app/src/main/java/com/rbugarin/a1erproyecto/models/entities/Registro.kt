package com.rbugarin.a1erproyecto.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Registro (
    @PrimaryKey(autoGenerate = true)
    val id : Long?=null,
    val nombre: String,
    val apellido: String,
    val correoelectronico: String,
    val accion: String,
    val animal: String
)
