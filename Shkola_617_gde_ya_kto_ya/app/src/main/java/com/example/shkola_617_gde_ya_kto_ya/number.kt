package com.example.shkola_617_gde_ya_kto_ya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class number : AppCompatActivity() {
   lateinit var numberp: EditText
   lateinit var numbert: EditText
        override fun onCreate(savedInstanceState: Bundle?) {
        var btn:Button? = null
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)
        btn = findViewById(R.id.button)
        numberp=findViewById(R.id.editNumberSigned)
        numbert=findViewById(R.id.editTextNumberSigned2)

        btn.setOnClickListener{
            showToast(numberp,numbert)
        }
    }
    fun showToast(answer:EditText,answer2:EditText) {
        if (answer.text.toString()==""||answer2.text.toString()==""||Integer.parseInt(answer.text.toString())>335 || Integer.parseInt(answer.text.toString())<105 ||
            Integer.parseInt(answer2.text.toString())>335 || Integer.parseInt(answer2.text.toString())<105 || answer.text.toString()==answer2.text.toString() ) {
       val t= Toast.makeText(applicationContext, "Такого кабинета не существует. Проверьте номера ещё раз", Toast.LENGTH_LONG)
            t.show()
    } else {
        sActiv()
    }
    }
    fun sActiv(){
        val i = Intent(this,result::class.java)
        val p= numberp.text.toString()
        val t= numbert.text.toString()
        i.putExtra(result.TOTAL1,p)
        i.putExtra("t",t)
        startActivity(i)
    }
}