package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity2.KEY_IMC"

class ResultActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        var tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        if(result < 18.6){
                tvClassificacao.text = "MAGREZA"
            }else if (result > 18.5 && result < 25){
                tvClassificacao.text = "NORMAL"
            }else if(result >= 25 && result < 30){
                tvClassificacao.text = "SOBREPESO"
            }else if(result >= 30 && result < 35) {
                tvClassificacao.text = "OBRESIDADE I"
            }else if ( result >= 35 && result < 40){
                tvClassificacao.text = "OBESIDADE II"
            }else{
                tvClassificacao.text = "OBESIDADE III"
            }
        }
    }
