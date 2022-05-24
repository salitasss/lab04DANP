package org.idnp.datastoresamplegra

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.GlobalScope
class MainActivity : AppCompatActivity() {

/*
    lateinit var textInput: AppCompatEditText
   */
    lateinit var counterManager: CounterDataStoreManager

   // lateinit var userManager: CounterDataStoreManager
    var nombre_semestre = ""
    var codigo = 0
    var periodo = ""
    var duracion = ""
    var escuela = ""
    var semestre = ""
    lateinit var setValueBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        counterManager = CounterDataStoreManager(this)
        setValueBtn = findViewById(R.id.btn_save)

/*
         Collect the counter value and set the text everytime the value changes
        lifecycleScope.launch {
            counterManager.context.collect { counter ->
                textInput.setText(counter.toString())
            }


        }
        /Set the current value of the counter
        setValueBtn.setOnClickListener {
            lifecycleScope.launch {
                counterManager.setCounter(textInput.text.toString().toInt())
            }
        }
*/

        buttonSave()

        observeData()

        val btnSecondActivity = findViewById(R.id.btnSecondActivity) as Button

        btnSecondActivity.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)


        }


    }







       /*

*/
    private fun observeData() {
/*
        //Updates age
           userManager.userPeriodoFlow.asLiveData().observe(this, {
               if (it != null) {
                   fname = it
                   tv_fname.text = it
               }
           })
        userManager.userAgeFlow.asLiveData().observe(this, {
            age = it
            tv_age.text = it.toString()
        })

        //Updates name
        userManager.userNameFlow.asLiveData().observe(this, {
            name = it
            tv_name.text = it.toString()
        })

        //Updates gender
        userManager.userGenderFlow.asLiveData().observe(this, {
            gender = if (it) "Male" else "Female"
            tv_gender.text = gender
        })
        */

    }

    private fun buttonSave() {

        //Gets the user input and saves it
        setValueBtn.setOnClickListener {

            periodo = periodo.toString()
            escuela = escuela.toString()
            semestre = semestre.toString()
            nombre_semestre = nombre_semestre.toString()
            duracion = duracion.toString()
            codigo = codigo.toString().toInt()



            //Stores the values
            GlobalScope.launch {
                counterManager.storeUser(periodo,escuela,codigo,nombre_semestre,semestre,duracion)
            }
        }


    }


}