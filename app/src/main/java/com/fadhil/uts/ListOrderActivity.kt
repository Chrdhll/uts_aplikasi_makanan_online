package com.fadhil.uts

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fadhil.uts.Adapter.AdapterMakanan
import com.fadhil.uts.model.modelMakanan

class ListOrderActivity : AppCompatActivity() {

    private lateinit var RecyclerViewMakanan : RecyclerView
    private lateinit var AdapterMakanan : AdapterMakanan

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_order)

        val menuMakanan = listOf(
            modelMakanan(R.drawable.makan1,"Chicken Curry","29 nov, 01.09 pm","$50.00","2 Items"),
            modelMakanan(R.drawable.makan2,"Bean burger","10 nov, 06.05 pm","$50.00","2 Items"),
            modelMakanan(R.drawable.makan3,"Coffe latte","29 nov, 01.09 pm","$50.00","2 Items"),
            modelMakanan(R.drawable.makan4,"Nasi Padang","30 nov, 08.45 pm","$50.00","2 Items"),
            modelMakanan(R.drawable.makan5,"Ayam betutu","28 nov, 07.00 pm","$50.00","2 Items")

        )

        //inisialisasi recyclerview dan adapter
        RecyclerViewMakanan = findViewById(R.id.RvMakanan)
        RecyclerViewMakanan.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        AdapterMakanan = AdapterMakanan(menuMakanan)
        RecyclerViewMakanan.adapter = AdapterMakanan

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}