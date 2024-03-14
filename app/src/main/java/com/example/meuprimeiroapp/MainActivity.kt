package com.example.meuprimeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.meuprimeiroapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Declaração do Layout com BINDING
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Declaração das VIEWS
        var botao = binding.button

        botao.setOnClickListener {
            var idade: String = binding.nomeEdit.text.toString()
            var peso: Double = binding.pesoEdit.text.toString().toDouble()
            var altura: Double = binding.alturaEdit.text.toString().toDouble()

            var imc: Double = (peso / (altura*altura))

            when(imc) {
                in 1.0..<18.5 -> binding.resultado.text = "MAGREZA"
                in 18.5..24.9 -> binding.resultado.text = "NORMAL"
                in 25.0..29.9 -> binding.resultado.text = "SOBREPESO"
                in 30.0..39.9 -> binding.resultado.text = "OBESIDADE"
                else -> binding.resultado.text = "OBESIDADE GRAVE"
            }

            var viewImc = binding.imc
            viewImc.text = imc.toString()
            //viewImc.text = String.format("%.2f", imc).toString() -> GAMBIARRA!!! NÃO USAR (mas funciona)
        }
        // Sempre que trabalhar com questões de arredondamentos, use o BIGDECIMAL
    }
}