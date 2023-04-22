package com.example.riddle

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.riddle.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        gg()
    }
    public val otv = arrayListOf<String>("Дорога","Имя","Музыка","Секрет","Туча","Сердце","Букварь","Море","Зубы и язык","Расческа","Холодильник","Нос","петух","Шахматист","Сорока")
    public var otvet = "Nice"


    fun gg() {

        var dataOne = intent.getStringExtra("numberPageOne")
        dataOne = "asd"
        binding.rb1.text=otv[0].toString()
        binding.rb2.text=otv[1].toString()
        binding.rb3.text=otv[2].toString()
        binding.rb4.text=otv[3].toString()
        binding.rb5.text=otv[4].toString()
        binding.rb6.text=otv[5].toString()
        binding.rb7.text=otv[6].toString()
        binding.rb8.text=otv[7].toString()
        binding.rb9.text=otv[8].toString()
        binding.rb10.text=otv[9].toString()
        binding.rb11.text=otv[10].toString()
        binding.rb12.text=otv[11].toString()
        binding.rb13.text=otv[12].toString()
        binding.rb14.text=otv[13].toString()
        binding.rb15.text=otv[14].toString()
    }
    fun btnClickGotoMain(view: View) {

        /*dataOne = "gotovo"*/
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("twoName",otvet.toString())
        setResult(RESULT_OK, intent)
        finish()


    }

    fun rb(view: View) {
        binding.gg.isEnabled = false
        binding.btnProverka.isEnabled = true

        val checked = (view as RadioButton).isChecked

        when (view.getId()) {
            binding.rb1.id -> {
                if (checked) {
                    otvet="0"
                }
            }binding.rb2.id -> {
                if (checked) {
                    otvet="1"
                }
            }binding.rb3.id -> {
                if (checked) {
                    otvet="2"
                }
            }binding.rb4.id -> {
                if (checked) {
                    otvet="3"
                }
            }binding.rb5.id -> {
                if (checked) {
                    otvet="4"
                }
            }binding.rb6.id -> {
                if (checked) {
                    otvet="5"
                }
            }binding.rb7.id -> {
                if (checked) {
                    otvet="6"
                }
            }binding.rb8.id -> {
                if (checked) {
                    otvet="7"
                }
            }binding.rb9.id -> {
                if (checked) {
                    otvet="8"
                }
            }binding.rb10.id -> {
                if (checked) {
                    otvet="9"
                }
            }binding.rb11.id -> {
                if (checked) {
                    otvet="10"
                }
            }binding.rb12.id -> {
                if (checked) {
                    otvet="11"
                }
            }binding.rb13.id -> {
                if (checked) {
                    otvet="12"
                }
            }binding.rb14.id -> {
                if (checked) {
                    otvet="13"
                }
            }binding.rb15.id -> {
                if (checked) {
                    otvet="14"
                }
            }

        }

    }
}


