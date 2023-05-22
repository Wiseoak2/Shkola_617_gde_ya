package com.example.shkola_617_gde_ya_kto_ya

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
     var scanBut: Button? = null
     var imgSave: ImageView? = null
     var numBut: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgSave=findViewById(R.id.img_save)
        scanBut=findViewById(R.id.cam_button)
        scanBut?.setOnClickListener(){
            startActivity(Intent(this, ScanActivity::class.java))
        }
        numBut=findViewById(R.id.buttonum)
        numBut?.setOnClickListener() {
            startActivity((Intent(this, number::class.java)))
        }
    }
}