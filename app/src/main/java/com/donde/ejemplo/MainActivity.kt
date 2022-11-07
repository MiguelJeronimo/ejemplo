package com.donde.ejemplo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var usuario: TextInputLayout
    private lateinit var password: TextInputLayout
    private lateinit var txtUsuario: EditText
    private lateinit var txtPasword: EditText
    private lateinit var btnEnviar: Button
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usuario = findViewById(R.id.usario)
        password = findViewById(R.id.password)
        txtUsuario = findViewById(R.id.txtUsuario)
        txtPasword = findViewById(R.id.txtPassword)
        btnEnviar = findViewById(R.id.enviar)
        btnEnviar.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.enviar->{
                //Toast.makeText(this,"Usuario: ${txtUsuario.getText()}/Contraseña: ${txtPasword.getText()}",Toast.LENGTH_SHORT).show()
                if (txtUsuario.getText().toString().equals("")&&txtPasword.getText().toString().equals("")){
                    usuario.error = "Ingresa tu usuario"
                    password.error = "Ingrese la contraseña"
                }
                else{
                    usuario.error = null
                    password.error = null
                    txtUsuario.setText("")
                    txtPasword.setText("")
                    intentPanel()
                }
            }
        }
    }
    private fun intentPanel(){
        val panel: Intent = Intent(this,Panel::class.java)
        startActivity(panel)
    }
}