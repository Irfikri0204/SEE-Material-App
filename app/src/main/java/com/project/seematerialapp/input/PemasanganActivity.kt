package com.project.seematerialapp.input

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.project.seematerialapp.R
import com.project.seematerialapp.databinding.ActivityPemasanganBinding
import com.project.seematerialapp.result.ResultPemasanganActivity
import java.math.RoundingMode

class PemasanganActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPemasanganBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPemasanganBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnHitung.setOnClickListener {
            var total : Double
            var tenaga_terampil = binding.tenagaTerampil.text.toString().toDouble()
            var tenaga_tidak_terampil = binding.tenagaTidakTerampil.text.toString().toDouble()
            var besi6 = binding.besiDia6.text.toString().toDouble()
            var papan = binding.papan.text.toString().toDouble()
            var pasir = binding.pasir.text.toString().toDouble()
            var semen = binding.semen.text.toString().toDouble()
            var kerikil = binding.kerikil.text.toString().toDouble()
            var air = binding.air.text.toString().toDouble()
            var precast = binding.precast.text.toString().toDouble()
            var paku = binding.paku.text.toString().toDouble()

            // Proses
            tenaga_terampil = tenaga_terampil  * 0.166805556
            tenaga_tidak_terampil = tenaga_tidak_terampil * 0.347216667
            besi6 = besi6 * 0.444
            papan = papan * 0.32
            pasir = pasir * 0.018129086
            semen =  semen * 0.347
            kerikil = kerikil * 0.02856
            air = air * 13.7484
            precast = precast * 5
            paku = paku * 0.01

            Log.d("Harga","Tenaga Terampil ${tenaga_terampil}")
            Log.d("Harga","Tenaga Tidak Terampil ${tenaga_tidak_terampil}")
            Log.d("Harga","Besi 6 ${besi6}")
            Log.d("Harga","Papan ${papan}")
            Log.d("Harga","Pasir ${pasir}")
            Log.d("Harga","Semen ${semen}")
            Log.d("Harga","Kerikil ${kerikil}")
            Log.d("Harga","Air ${air}")
            Log.d("Harga","Precast ${precast}")
            Log.d("Harga","Paku ${paku}")

            total = (tenaga_terampil + tenaga_tidak_terampil + besi6 + papan + pasir + semen + kerikil + air + precast + paku)
            total = total.toBigDecimal().setScale(2, RoundingMode.DOWN).toDouble()
            Log.d("Total", "${total}")
            val intent = Intent(this, ResultPemasanganActivity::class.java)
            intent.putExtra("total", total.toString())
            startActivity(intent)
            finish()
        }
    }
}