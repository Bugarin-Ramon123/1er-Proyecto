package com.rbugarin.a1erproyecto

import android.app.AlertDialog
import android.content.DialogInterface
import android.media.MediaCodec
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var rbAdoptar : RadioButton
    private lateinit var rbComprar : RadioButton
    private lateinit var rbInternar : RadioButton

    private lateinit var checkGato : CheckBox
    private lateinit var checkHamster : CheckBox
    private lateinit var checkConejo : CheckBox
    private lateinit var checkPerro : CheckBox
    private lateinit var checkLoro : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabconf = findViewById<FloatingActionButton>(R.id.fabConfirmación)
        fabconf.setOnClickListener(fabClick)

        checkGato = findViewById(R.id.cbGato)
        checkHamster = findViewById(R.id.cbHamster)
        checkConejo = findViewById(R.id.cbConejo)
        checkPerro = findViewById(R.id.cbPerro)
        checkLoro = findViewById(R.id.cbLoro)

        checkGato.setOnCheckedChangeListener(changeChecked)
        checkHamster.setOnCheckedChangeListener(changeChecked)
        checkConejo.setOnCheckedChangeListener(changeChecked)
        checkPerro.setOnCheckedChangeListener(changeChecked)
        checkLoro.setOnCheckedChangeListener(changeChecked)
    }

    private val changeChecked = CompoundButton.OnCheckedChangeListener { button, checked ->
        var listaseleccionada: MutableList<Animal> = arrayListOf()
        var animalselect : Animal
        val adaptadorAnimles = adaptadorAnimles(listaseleccionada)
        val rv = findViewById<RecyclerView>(R.id.recyclercards)
        rv.layoutManager = LinearLayoutManager(this)

        if(cbGato.isChecked) {
            animalselect = createAnimals().get(0)
            listaseleccionada.add(animalselect)
        }
        if(cbHamster.isChecked) {
            animalselect = createAnimals().get(1)
            listaseleccionada.add(animalselect)
        }
        if(cbConejo.isChecked) {
            animalselect = createAnimals().get(2)
            listaseleccionada.add(animalselect)
        }
        if(cbPerro.isChecked) {
            animalselect = createAnimals().get(3)
            listaseleccionada.add(animalselect)
        }
        if(cbLoro.isChecked) {
            animalselect = createAnimals().get(4)
            listaseleccionada.add(animalselect)
        }
        rv.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        rv.adapter = adaptadorAnimles
        adaptadorAnimles.notifyDataSetChanged()
    }

    private val fabClick = View.OnClickListener { fab ->
        val nombre = findViewById<TextView>(R.id.etNombre)
        val apellido = findViewById<TextView>(R.id.etApellido)
        val ce = findViewById<TextView>(R.id.etCorreoElectronico)
        var acc= ""
        var ani = ""
        if(radioAdoptar.isChecked){
            acc = "Adoptar"
        }
        if(radioComprar.isChecked){
            acc = "Comprar"
        }
        if(radioInternar.isChecked){
            acc = "Internar"
        }

        if(cbGato.isChecked){
            ani = ani +" Gato"
        }
        if(cbConejo.isChecked){
            ani = ani+ " Conejo"
        }
        if(cbHamster.isChecked){
            ani = ani + " Hamster"
        }
        if(cbLoro.isChecked){
            ani = ani + " Loro"
        }
        if(cbPerro.isChecked){
            ani= ani + " Perro"
        }
        val conf = AlertDialog.Builder(fab.context)
            .setTitle("CONFIRMACIÓN")
            .setMessage("INFORMACIÓN INGRESADA\n" +
                    "NOMBRE: " +nombre.text+"\n"+
                    "APELLIDO: " +apellido.text+"\n"+
                    "CORREO ELECTRÓNICO: " +ce.text+"\n"+
                    "ACCIÓN: "+acc+"\n"+
                    "ANIMAL/ANIMALES: "+ani)
            .setPositiveButton("Ok", object: DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, p1: Int) {
                    Toast.makeText(fab.context, "CONFIRMADO", Toast.LENGTH_LONG).show()
                }
            })
            .setNegativeButton("No", null)
            .create()

        conf.show()
    }

    fun createAnimals(): List<Animal> {
        val animals = mutableListOf<Animal>()

        animals.add(
            Animal(
                R.drawable.ic_cat_face,
                "Gato",
                "El gato es un mamífero doméstico de la familia de los felinos, pertenece a la especie Felis silvestris catus."
            )
        )

        animals.add(
            Animal(
                R.drawable.ic_hamster,
                "Hamster",
                "El hamster es un mamífero roedor parecido al ratón, de cuerpo rechoncho, pelo suave y orejas, patas y cola cortas."
            )
        )

        animals.add(
            Animal(
                R.drawable.ic_conejo,
                "Conejo",
                "Mamífero de cuerpo alargado y arqueado de unos 40 cm de longitud, pelo suave y espeso, orejas largas, cola corta y patas traseras más desarrolladas que las delanteras."
            )
        )

        animals.add(
            Animal(
                R.drawable.ic_dog,
                "Perro",
                "El perro, cuyo nombre cientifico es Canislupus familliaris, es un mamífero carnivoro doméstico de la familia de los cáninos."
            )
        )

        animals.add(
            Animal(
                R.drawable.ic_loro,
                "Loro",
                "Ave trepadora de 30 a 40 cm de longitud, con el plumaje de colores muy vistosos y variados, y el pico fuerte, grueso y curvo; es capaz de imitar la voz humana."
            )
        )

        return animals
    }
}