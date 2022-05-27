package castor.no.c.programar.preferenciascompartidas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var txtNombre:TextView
    lateinit var txtTelefono:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtNombre = findViewById(R.id.txtNombre)
        txtTelefono = findViewById(R.id.txtTelefono)
    }

    fun abreModificar(v: View){
        val intent = Intent(this, Agregar::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        //Obtener datos grabados en el shared preference
        val misPreferencias = getSharedPreferences("persona", Context.MODE_PRIVATE)
        val nombre = misPreferencias.getString("nombre", "No se encuentra ese dato")
        val telefono = misPreferencias.getString("telefono","----------")
        txtNombre.text = nombre
        txtTelefono.text = telefono
    }

}