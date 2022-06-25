package com.adamrizkialfatih.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adamrizkialfatih.recycleview.adapter.AdapterTeamBasket
import com.adamrizkialfatih.recycleview.databinding.ActivityMainBinding
import com.adamrizkialfatih.recycleview.model.Pemain

class MainActivity : AppCompatActivity(){
private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Stephen Curry",R.drawable.curry,"Point Guard","1,88 M","Akron","14 Maret 1988"))
        listPemain.add(Pemain("Klay Thompson",R.drawable.klay,"Shooting Guard","1,98 M","Los Angeles","8 Februari 1990"))
        listPemain.add(Pemain("Draymond Green",R.drawable.dray,"Power Forward","1,98 M","Michigan","4 Maret 1990"))
        listPemain.add(Pemain("Andrew Wiggins",R.drawable.wiggins,"Small Forward","2,01 M","Tornhill","23 Februari 1995"))
        listPemain.add(Pemain("Jordan Poole",R.drawable.poole,"Point Guard","1,93 M","Millwaukee","19 Jumi 1999"))

        binding.list.adapter = AdapterTeamBasket(this,listPemain,object : AdapterTeamBasket.OnClickListener {
            override fun detailData(item: Pemain?) {
                TODO("Not yet implemented")
            }

        } )
    }
}