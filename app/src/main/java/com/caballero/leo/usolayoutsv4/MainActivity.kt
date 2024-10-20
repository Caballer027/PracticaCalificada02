package com.caballero.leo.usolayoutsv4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Botón para ir a activity_pedido
        findViewById<Button>(R.id.btnActivityPedido).setOnClickListener {
            val intent = Intent(this, activity_pedido::class.java)
            startActivity(intent)
        }

        // Botón para ir a Ejercicio01
        findViewById<Button>(R.id.btnEjercicio01).setOnClickListener {
            val intent = Intent(this, Ejercicio01::class.java)
            startActivity(intent)
        }

        // Botón para ir a Ejercicio02
        findViewById<Button>(R.id.btnEjercicio02).setOnClickListener {
            val intent = Intent(this, Ejercicio02::class.java)
            startActivity(intent)
        }
    }
}
