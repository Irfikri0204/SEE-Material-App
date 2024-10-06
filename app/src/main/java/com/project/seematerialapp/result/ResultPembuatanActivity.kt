package com.project.seematerialapp.result

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.project.seematerialapp.R
import com.project.seematerialapp.databinding.ActivityResultPembuatanBinding

class ResultPembuatanActivity : AppCompatActivity() {
    private lateinit var binding : ActivityResultPembuatanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultPembuatanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.tvTotal.setText(intent.getStringExtra("total"))
        binding.btnBack.setOnClickListener {
            onBackPressed()
            finish()
        }
    }
}