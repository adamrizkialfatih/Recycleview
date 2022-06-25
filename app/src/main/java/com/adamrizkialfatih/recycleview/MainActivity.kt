package com.adamrizkialfatih.recycleview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)
                    val posisi = this.findViewById<TextView>(R.id.txtposisi)
                    val tinggi = this.findViewById<TextView>(R.id.txttinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txttempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txttanggallahir)

                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }


                }.show()

            }

        } )
    }
}