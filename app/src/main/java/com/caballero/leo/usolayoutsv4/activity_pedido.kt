package com.caballero.leo.usolayoutsv4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class activity_pedido : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido)

        // Referencias a los campos de texto
        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        val editTextNumero = findViewById<EditText>(R.id.editTextNumero)
        val editTextProductos = findViewById<EditText>(R.id.editTextProductos)
        val editTextDireccion = findViewById<EditText>(R.id.editTextDireccion)


        // Llamar
        findViewById<ImageButton>(R.id.imbDial).setOnClickListener {
            val numero = editTextNumero.text.toString()
            if (numero.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$numero")
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, ingresa un número", Toast.LENGTH_SHORT).show()
            }
        }

        // WhatsApp
        findViewById<ImageButton>(R.id.imbWsp).setOnClickListener {
            val nombre = editTextNombre.text.toString()
            val productos = editTextProductos.text.toString()
            val direccion = editTextDireccion.text.toString()

            if (nombre.isNotEmpty() && productos.isNotEmpty() && direccion.isNotEmpty()) {
                val mensaje = "Hola $nombre, tus productos: $productos están en camino a la dirección: $direccion"
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    setPackage("com.whatsapp")
                    putExtra(Intent.EXTRA_TEXT, mensaje)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, completa los campos antes de enviar", Toast.LENGTH_SHORT).show()
            }
        }

        // Google Maps
        findViewById<ImageButton>(R.id.imbMaps).setOnClickListener {
            val direccion = editTextDireccion.text.toString()
            if (direccion.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$direccion"))
                intent.setPackage("com.google.android.apps.maps")
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, ingresa una dirección", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
