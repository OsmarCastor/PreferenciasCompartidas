package castor.no.c.programar.preferenciascompartidas

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Agregar : AppCompatActivity() {
    lateinit var txtPersona: EditText
    lateinit var txtTelefono: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar)
        txtPersona = findViewById(R.id.txtPersona)
        txtTelefono = findViewById(R.id.txtTel)
    }
    fun abreModificar(v: View){
        val misPreferencias = getSharedPreferences("persona", Context.MODE_PRIVATE)
        val editPreference = misPreferencias.edit()
        with(misPreferencias.edit()){
            putString("nombre", txtPersona.text.toString())
            putString("telefono", txtTelefono.text.toString())
            commit()
        }
        Toast.makeText(this, "Se grabó correctamente", Toast.LENGTH_LONG).show()
        finish()
    }
}