package com.rbugarin.a1erproyecto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rbugarin.a1erproyecto.R
import com.rbugarin.a1erproyecto.models.entities.Registro

class RegistroAdapter (private val registros: List<Registro>): RecyclerView.Adapter<RegistroAdapter.RegistroAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegistroAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.registros ,parent,false)

        return RegistroAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RegistroAdapterViewHolder, position: Int) {
        val registro = registros[position]
        holder.onBind(registro)
    }

    override fun getItemCount(): Int {
        return registros.size
    }

    inner class RegistroAdapterViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        fun onBind(registro:Registro){

            val nombre = view.findViewById<TextView>(R.id.txt_nombre)
            val apellido = view.findViewById<TextView>(R.id.txt_apellido)
            val correoelectronico = view.findViewById<TextView>(R.id.txt_correoelectronico)
            val accion = view.findViewById<TextView>(R.id.txt_accion)
            val animal = view.findViewById<TextView>(R.id.txt_animal)
            

            nombre.text = registro.nombre
            apellido.text = registro.apellido
            correoelectronico.text = registro.correoelectronico
            accion.text = registro.accion
            animal.text = registro.animal
        }
    }
}