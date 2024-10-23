package com.example.calculadora_imc_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Resultado : AppCompatActivity() {

    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textPeso = findViewById(R.id.textPeso)
        textAltura = findViewById(R.id.textAltura)
        textResultado = findViewById(R.id.textResultado)

        val bundle = intent.extras

        if (bundle != null) {
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = ("Peso informado: $peso kg")
            textAltura.text = ("Altura informada: $altura cm")

            val imc = peso / (altura * altura)
            val imcFormat = String.format("%.2f", imc)

            if (imc < 18.5) {
                textResultado.text = ("Imc: $imcFormat, Baixo")
            } else if (imc >= 18.5 && imc <= 24.9) {
                textResultado.text = ("Imc: $imcFormat, Normal")
            } else if (imc >= 25 && imc <= 29) {
                textResultado.text = ("Imc: $imcFormat, Sobrepeso")
            } else if (imc >= 30 && imc <= 39.9) {
                textResultado.text = ("Seu imc é: $imcFormat")
            }
        }
    }
}
