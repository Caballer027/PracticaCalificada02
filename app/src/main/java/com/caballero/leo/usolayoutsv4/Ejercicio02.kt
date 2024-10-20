package com.caballero.leo.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ejercicio02 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio02)

        val btnRegistrar = findViewById<Button>(R.id.btn_registrar)
        btnRegistrar.setOnClickListener {
            val nombre = findViewById<EditText>(R.id.et_nombre_cliente).text.toString()
            val numero = findViewById<EditText>(R.id.et_numero_cliente).text.toString()
            val productos = findViewById<EditText>(R.id.et_productos).text.toString()
            val direccion = findViewById<EditText>(R.id.et_direccion).text.toString()

            if (nombre.isNotEmpty() && numero.isNotEmpty() && productos.isNotEmpty() && direccion.isNotEmpty()) {
                val intent = Intent(this, activity_pedido::class.java).apply {
                    putExtra("nombre", nombre)
                    putExtra("numero", numero)
                    putExtra("productos", productos)
                    putExtra("direccion", direccion)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}