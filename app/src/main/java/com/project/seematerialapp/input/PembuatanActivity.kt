package com.project.seematerialapp.input

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.project.seematerialapp.R
import com.project.seematerialapp.databinding.ActivityPembuatanBinding
import com.project.seematerialapp.result.ResultPembuatanActivity
import kotlin.math.log

class PembuatanActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPembuatanBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPembuatanBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var total : Double
        var tenaga_terampil = binding.tenagaTerampil.text.toString().toDouble()
        var tenaga_tidak_terampil = binding.tenagaTidakTerampil.text.toString().toDouble()
        var besi6 = binding.besiDia6.text.toString().toDouble()
        var besi10 = binding.besiDia10.text.toString().toDouble()
        var pasir = binding.pasir.text.toString().toDouble()
        var semen = binding.semen.text.toString().toDouble()
        var kerikil = binding.kerikil.text.toString().toDouble()
        var air = binding.air.text.toString().toDouble()
        var kawat = binding.kawat.text.toString().toDouble()
        var abu_sekam = binding.abuSekam.text.toString().toDouble()
        var investasi = binding.investasi.text.toString().toDouble()

        // Proses
        binding.btnHitung.setOnClickListener {
            tenaga_terampil = tenaga_terampil  * 0.285
            tenaga_tidak_terampil = tenaga_tidak_terampil * 0.393
            besi6 = besi6 * 1.52
            besi10 = besi10 * 2.7
            pasir = pasir * 0.05
            semen =  semen * 0.165
            kerikil = kerikil * 0.08
            air = air * 0.0004
            kawat = kawat * 0.05
            abu_sekam = abu_sekam * 0.34
            investasi = investasi * 1

            Log.d("Harga","Tenaga Terampil ${tenaga_terampil}")
            Log.d("Harga","Tenaga Tidak Terampil ${tenaga_tidak_terampil}")
            Log.d("Harga","Besi 6 ${besi6}")
            Log.d("Harga","Besi 10 ${besi10}")
            Log.d("Harga","Pasir ${pasir}")
            Log.d("Harga","Semen ${semen}")
            Log.d("Harga","Kerikil ${kerikil}")
            Log.d("Harga","Air ${air}")
            Log.d("Harga","Kawat ${kawat}")
            Log.d("Harga","Abu Sekam ${abu_sekam}")
            Log.d("Harga","Investasi ${investasi}")

            total = (tenaga_terampil + tenaga_tidak_terampil + besi6 + besi10 + pasir + semen + kerikil + air + kawat + abu_sekam+investasi)/5
            Log.d("Total", "${total}")
            val intent = Intent(this, ResultPembuatanActivity::class.java)
            intent.putExtra("total", total.toString())
            startActivity(intent)
        }

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onResume() {
        super.onResume()
    }
}