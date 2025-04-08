package com.example.mquiz

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//val tombollnjt = findViewById<Button>(R.id.btnnext)
//        tombollnjt.setOnClickListener{
//            val intent = Intent(this, Masukdaftarr::class.java)
//            startActivity(intent)
//        }

        bottomNavigationView =findViewById(R.id.bottom_navigasi)


bottomNavigationView.setOnItemSelectedListener { menuItem ->
    when(menuItem.itemId){
        R.id.beranda_logo ->{
            replaceFragment(fragment_beranda())
            true
        }
        R.id.daftar_siswa ->{
            replaceFragment(daftar_siswa())
            true
        }
        R.id.nilai_siswa ->{
            replaceFragment(nilai_siswa())
            true
        }
else->false
    }
}
        replaceFragment(fragment_beranda())

    }

    private fun replaceFragment(fragment: Fragment){
supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
}