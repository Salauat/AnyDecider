package kz.cheil.dev.anydecider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val foodList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decideBtn.visibility = View.INVISIBLE

        decideBtn.setOnClickListener {
            val random = Random()
            val randomFood = random.nextInt(foodList.count())

            selectedItemTxt.text = foodList[randomFood]
        }

        addItemBtn.setOnClickListener {
            val newFood = addItemTxt.text.toString()
            if(newFood?.trim().length>0) {
                foodList.add(newFood)
                addItemTxt.text.clear()
                decideBtn.visibility = View.VISIBLE
            } else {
                Toast.makeText(applicationContext, "Please, enter item name", Toast.LENGTH_SHORT).show()
                addItemTxt.requestFocus()
            }
        }
    }
}
