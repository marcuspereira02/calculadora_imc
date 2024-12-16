package com.comunidadedevspace.imc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity2.KEY_IMC"

class ResultActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val btnNovoCalculo = findViewById<Button>(R.id.btn_novoCalculo)
        val btnTabelaImc = findViewById<Button>(R.id.btn_tabelaIMC)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        var tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        val tvSugestao = findViewById<TextView>(R.id.tv_sugestao)

        tvResult.text = result.toString()

        if (result < 18.6) {
            tvClassificacao.text = "ABAIXO DO PESO"
            tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.red))
            tvSugestao.text =
                "Seu IMC indica que você está abaixo do peso ideal. Que tal buscar orientação de um nutricionista para cuidar melhor da sua saúde?"
        } else if (result > 18.5 && result < 25) {
            tvClassificacao.text = "NORMAL"
            tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.green))
            tvSugestao.text =
                "Parabéns! Seu IMC está dentro do peso ideal. Continue mantendo hábitos saudáveis para preservar seu bem-estar."
        } else if (result >= 25 && result < 30) {
            tvClassificacao.text = "SOBREPESO"
            tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.yellow))
            tvSugestao.text =
                "Seu IMC indica sobrepeso. Pequenas mudanças na alimentação e na rotina de atividades físicas podem fazer toda a diferença para sua saúde."
        } else if (result >= 30 && result < 35) {
            tvClassificacao.text = "OBRESIDADE I"
            tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.red))
            tvSugestao.text =
                "Seu IMC indica obesidade grau I. É importante buscar acompanhamento médico e adotar hábitos saudáveis para melhorar sua qualidade de vida."
        } else if (result >= 35 && result < 40) {
            tvClassificacao.text = "OBESIDADE II"
            tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.red))
            tvSugestao.text =
                "Atenção! Seu IMC indica obesidade grau II. Procure um profissional de saúde para um plano adequado e cuide da sua saúde."
        } else {
            tvClassificacao.text = "OBESIDADE III"
            tvClassificacao.setTextColor(ContextCompat.getColor(this, R.color.red))
            tvSugestao.text =
                "Seu IMC indica obesidade grau III (obesidade mórbida). É essencial buscar apoio médico e nutricional o quanto antes para proteger sua saúde."
        }

        btnNovoCalculo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(KEY_MAIN_ACTIVITY, "")
            startActivity(intent)
        }

        btnTabelaImc.setOnClickListener {
            val intent = Intent(this, TableIMCActivity::class.java)
            intent.putExtra(KEY_TABLE_IMC, result)
            startActivity(intent)
        }
    }
}
