package com.project.seematerialapp.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.project.seematerialapp.PrecastActivity
import com.project.seematerialapp.R
import com.project.seematerialapp.databinding.ActivityMainBinding
import com.project.seematerialapp.input.PemasanganActivity
import com.project.seematerialapp.input.PembuatanActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.cardPembuatan.setOnClickListener {
            val intent = Intent(this, PembuatanActivity::class.java)
            startActivity(intent)
        }
        binding.cardPemasangan.setOnClickListener {
            val intent = Intent(this, PemasanganActivity::class.java)
            startActivity(intent)
        }
        binding.cardPrecast.setOnClickListener {
            val intent = Intent(this, PrecastActivity::class.java)
            startActivity(intent)
        }
    }
}