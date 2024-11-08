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
        val textViewNombre = findViewById<TextView>(R.id.textViewNombre)
        val textViewNumero = findViewById<TextView>(R.id.textViewNumero)
        val textViewProductos = findViewById<TextView>(R.id.textViewProductos)
        val textViewDireccion = findViewById<TextView>(R.id.textViewDireccion)

        // Obtener los datos del intent
        val nombre = intent.getStringExtra("nombre")
        val numero = intent.getStringExtra("numero")
        val productos = intent.getStringExtra("productos")
        val direccion = intent.getStringExtra("direccion")

        // Asignar los valores a los TextView
        textViewNombre.text = nombre
        textViewNumero.text = numero
        textViewProductos.text = productos
        textViewDireccion.text = direccion

        // Llamar
        findViewById<ImageButton>(R.id.imbDial).setOnClickListener {
            val numeroTelefono = textViewNumero.text.toString()
            if (numeroTelefono.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$numeroTelefono")
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, ingresa un número", Toast.LENGTH_SHORT).show()
            }
        }

        // WhatsApp
        findViewById<ImageButton>(R.id.imbWsp).setOnClickListener {
            val nombreCliente = textViewNombre.text.toString()
            val listaProductos = textViewProductos.text.toString()
            val direccionEnvio = textViewDireccion.text.toString()

            if (nombreCliente.isNotEmpty() && listaProductos.isNotEmpty() && direccionEnvio.isNotEmpty()) {
                val mensaje = "Hola $nombreCliente, tus productos: $listaProductos están en camino a la dirección: $direccionEnvio"
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
            val direccionEnvio = textViewDireccion.text.toString()
            if (direccionEnvio.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$direccionEnvio"))
                intent.setPackage("com.google.android.apps.maps")
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, ingresa una dirección", Toast.LENGTH_SHORT).show()
            }
        }
    }
}