package hn.edu.ujcv.pmd_2021_ii_p1_proyecto1_parte2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hn.edu.ujcv.pmd_2021_ii_p1_proyecto1_parte2.Clases.Libro
import kotlinx.android.synthetic.main.activity_mostrar_libro.*
import kotlinx.android.synthetic.main.activity_mostrar_libro.btnBuscar
import kotlinx.android.synthetic.main.activity_mostrar_prestamo.*

class BuscarLibroActivity : AppCompatActivity() {
    var valoresEnviados: HashMap<Int, Libro> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_libro)
        inicalizar()
        btnBuscar.setOnClickListener{buscarLibro()}
        btnRegresar.setOnClickListener{regresar()}
    }

    private fun regresar() {
        val intentnRegistroLibro = Intent(this, RegistroLibroActivity::class.java)
        startActivity(intentnRegistroLibro)
    }

    private fun buscarLibro(){

        var datoBuscado: Libro? = valoresEnviados[txtIngreseNumeroDeLibro.text.toString().toInt()]

        if (datoBuscado == null){
            val toast = Toast.makeText(applicationContext, "Este numero de libro no existe", Toast.LENGTH_LONG)
            toast.show()
        }else{
            txvMostrarNombreDeLibro.setText(datoBuscado.nombreDeLibro)
            txvMostrarAutor.setText(datoBuscado.autor)
            txvMostrarEditorial.setText(datoBuscado.editorial)
            txvMostrarFechaDePublicacion.setText(datoBuscado.fechaDePublicacion)
        }
    }


    private fun inicalizar(){
        var intent         = getIntent()
        valoresEnviados    = intent.getSerializableExtra("valores") as HashMap<Int, Libro>
    }

}