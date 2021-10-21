package com.example.ladm_u2_practica1_presentacion_de_dia_de_muertos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ladm_u2_practica1_presentacion_de_dia_de_muertos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var b : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(Lienzo(this))
    }
}