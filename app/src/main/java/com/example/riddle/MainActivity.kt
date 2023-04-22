package com.example.riddle

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.riddle.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    val myText = result.data?.getStringExtra("twoName")
                    if (myText != null) {
                        binding.txtVibar.text=otv[myText.toInt()]
                        if(myText.toInt()==OtvetNum)
                        {
                            coutner++
                            binding.linearLayoutOtvet1.setBackgroundColor(Color.GREEN)
                        }else
                        {
                            binding.linearLayoutOtvet1.setBackgroundColor(Color.RED)
                            counternepravil++
                        }
                        binding.textView4.text="${coutner}/${countercount}"


                    }
                }
            }
    }
    public var coutner = 0
    public var countercount = 0
    public var counternepravil = 0
    public val zagadki = arrayListOf<String>("Поднимается в гору, спускается с неё, но остаётся на месте. Что это?",
        "Что принадлежит тебе, но используют его другие. Что это?",
        "Она может быть быстрой или медленной, но не передвигается. Что это?",
        "Этим можно поделиться только один раз. Что это?",
        "Летает, а крыльев нет. Плачет, а глаз нет. Что это?",
        "Что можно разбить, даже не дотронувшись. Что это?",
        "В этом слове 7 букв. Если из него убрать 1 букву, то останется только 2 буквы. Что это за слово?",
        "Кругом вода, а с питьем беда. ",
        "Тридцать два молотят, один поворачивает.",
        "Зубов много, а ничего не ест.",
        "Мама попросила достать из холодильника бутылку лимонада, банку зелёного горошка и пакет молока. Что ты откроешь первым?",
        "Есть всегда у людей и есть всегда у кораблей.",
        "Не ездок, а со шпорами, не сторож, а всех будит",
        "Этот человек может поднять слона и лошадь. Кто это?",
        "Вертится, стрекочет, Весь день хлопочет.")


    public val otv = arrayListOf<String>("Дорога","Имя","Музыка","Секрет","Туча","Сердце","Букварь","Море","Зубы и язык","Расческа","Холодильник","Нос","петух","Шахматист","Сорока")
    private  var launcher: ActivityResultLauncher<Intent>? = null
    var exzaga = emptyArray<Int>()
    var OtvetNum = 0

    fun btnGetZagadka(view: View) {
        if(countercount>=10)
        {
            binding.btnZaga.isEnabled=false
            binding.btnrebut.isEnabled=true
            Toast.makeText(getApplicationContext(), "Вы решили правильно ${coutner} загадок из 10! И ${counternepravil} неправильно!", Toast.LENGTH_SHORT)
                .show();
            return
        }
        randGenerated()
        binding.txtTextZagadki.text=zagadki[OtvetNum]
        binding.btnZaga.isEnabled=false
        binding.btnOtvet.isEnabled=true
        binding.linearLayoutOtvet1.setBackgroundColor(Color.WHITE)

    }
    fun randGenerated() {
        val rand=Random.nextInt(0, 14)
        val found = exzaga.any { rand == it}
        if(found)
        {
            randGenerated()
        }else
        {
            OtvetNum= rand
            exzaga+=OtvetNum
        }
    }

    fun btnGetOtvet(view: View) {
        binding.btnOtvet.isEnabled=false
        binding.btnZaga.isEnabled=true
        val intent = Intent(this, MainActivity2::class.java)
        launcher?.launch(intent)
        countercount++
        binding.textView5.text=countercount.toString()
    }

    fun btnrebut(view: View) {
        coutner=0
        countercount=0
        binding.btnZaga.isEnabled=true
        binding.btnrebut.isEnabled=false
        binding.txtVibar.text=" "
        binding.textView4.text="0/0"
        binding.textView5.text="0"

    }

}