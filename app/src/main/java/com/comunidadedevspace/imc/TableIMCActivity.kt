package com.comunidadedevspace.imc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_TABLE_IMC = "TableIMC.Key"

class TableIMCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_table_imcactivity)

        val result = intent.getFloatExtra(KEY_TABLE_IMC, 0f)
        val tv_Imc = findViewById<TextView>(R.id.tv_tableImc)
        val btn_NovoCalculo = findViewById<Button>(R.id.btn_novoCalculoTable)
        val btn_Retornar = findViewById<Button>(R.id.btn_resultadoImc)

        tv_Imc.text = result.toString()

        if(result < 18.6){
            tv_Imc.setTextColor(ContextCompat.getColor(this, R.color.red))
        }else if (result > 18.5 && result < 25){
            tv_Imc.setTextColor(ContextCompat.getColor(this,R.color.green))
        }else if(result >= 25 && result < 30){
            tv_Imc.setTextColor(ContextCompat.getColor(this, R.color.yellow))
        }else if(result >= 30 && result < 35) {
            tv_Imc.setTextColor(ContextCompat.getColor( this, R.color.red))
        }else if ( result >= 35 && result < 40){
            tv_Imc.setTextColor(ContextCompat.getColor( this, R.color.red))
        }else{
            tv_Imc.setTextColor(ContextCompat.getColor( this, R.color.red))
        }

        btn_Retornar.setOnClickListener {
            val intent = Intent(this, ResultActivity2::class.java)
            intent.putExtra(KEY_RESULT_IMC, result)
            startActivity(intent)
        }

        btn_NovoCalculo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(KEY_MAIN_ACTIVITY, "")
            startActivity(intent)
        }
        }
    }