package com.example.bmicalculator

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_Calculate.setOnClickListener(){
            val weight = Weight_Text.text.toString().toDouble()
            val height = Height_Text.text.toString().toDouble()

            val bmi = calculateBMI(height, weight)
            val status : String

            if(bmi < 18.5) {
                status = "Under"
                img_Empty.setImageResource(R.drawable.under)
            }
            else if (bmi <= 24.9){
                 status = "Normal"
                img_Empty.setImageResource(R.drawable.normal)}
            else{
            status = "Over"
            img_Empty.setImageResource(R.drawable.over)
        }
            BMIresult_Text.text = "BMI : %.2f (%s)".format(bmi, status)
        }
        btn_reset.setOnClickListener(){
            img_Empty.setImageResource(R.drawable.empty)

            BMIresult_Text.text = null
            Weight_Text.text = null
            Height_Text.text = null

            Weight_Text.requestFocus()
        }



    }



    public fun calculateBMI (height:Double, weight:Double) : Double{
        return weight / (height * height)
    }
}
