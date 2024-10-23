package com.example.calculadora_imc_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalcular: Button

    private lateinit var editTextPeso: EditText
    private lateinit var editTextAltura: EditText




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         btnCalcular =findViewById(R.id.btn_Calcular)
         editTextPeso = findViewById(R.id.inputTextPeso)
         editTextAltura = findViewById(R.id.inputTextAltura)



        btnCalcular.setOnClickListener {

            val intent = Intent(this, Resultado::class.java)

            val peso = editTextPeso.text.toString()
            val altura = editTextAltura.text.toString()

            if (peso.isNotEmpty() && altura.isNotEmpty()){

                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura",altura.toDouble())

            }

            startActivity( intent )

        }

    }
}