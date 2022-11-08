package com.donde.ejemplo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

/*
* para esta actividad se utilizo un emptyactivity
* */

class Panel : AppCompatActivity(), MenuItem.OnMenuItemClickListener {
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var toolbar: Toolbar
    lateinit var navigationView: NavigationView
    //private lateinit var toolbar: Toolbar
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.navegacion)
        //Agrega utilidades a la toolbar, asi como el incono de hamburguesa, y los iconos de cuando se despliegue el menu y cuando este cerrado
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open,R.string.nav_close)
        //agrega el evento al drawelayout, recibe por parametro el actionBarDrawerToggle en la cual se encuentra las animaciones
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        //sincroniza los estados del navigationDrawer
        actionBarDrawerToggle.syncState()
        navigationView = findViewById(R.id.barraNavegacion)
        //a cada item del menuo agregamos su evento MenuItemClickListener
        navigationView.menu.findItem(R.id.agregar).setOnMenuItemClickListener(this)
        navigationView.menu.findItem(R.id.item2).setOnMenuItemClickListener(this)
    }

    fun ventana2(){
        val intent:Intent = Intent(this, ventana::class.java)
        startActivity(intent)
    }
    //eventos de menuClick del los submenus del navigationDrawer
    override fun onMenuItemClick(p0: MenuItem?): Boolean {
        when(p0?.itemId){
            R.id.agregar->{
                ventana2()
            }
            R.id.item2->{drawerLayout.closeDrawer(Gravity.NO_GRAVITY)}
        }
        return true
    }
}


