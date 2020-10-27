package com.rbugarin.a1erproyecto.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rbugarin.a1erproyecto.R
import com.rbugarin.a1erproyecto.adapters.RegistroAdapter
import com.rbugarin.a1erproyecto.viewmodels.ActivityAddRegistroViewModel
import com.rbugarin.a1erproyecto.viewmodels.MainActivityViewModel

class ActivityAddRegistro : AppCompatActivity() {
    private val activityAddRegistroViewModel: ActivityAddRegistroViewModel by viewModels()
    private var registroAdapter: RegistroAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_registros)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_registros)
        recyclerView.layoutManager = LinearLayoutManager(this)

        activityAddRegistroViewModel.getAllContent().observe(this, { registros ->
            registroAdapter = RegistroAdapter(registros)

            recyclerView.adapter = registroAdapter

            registroAdapter?.notifyDataSetChanged()
        })
    }
}