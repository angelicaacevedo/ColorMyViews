package com.example.colormyviews

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var currentColor = R.color.grey
    private var boxOneColor = R.color.grey
    private var boxTwoColor = R.color.grey
    private var boxThreeColor = R.color.grey
    private var boxFourColor = R.color.grey
    private var boxFiveColor = R.color.grey

    private val sharedPreferences: SharedPreferences
        get() {
            return this.getSharedPreferences("colors", Context.MODE_PRIVATE)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadSavedColors()
        setColorButtonsAction()
        setBoxColorAction()
    }

    override fun onDestroy() {
        super.onDestroy()
        val editor = sharedPreferences.edit()
        editor.putInt("boxOne", boxOneColor)
        editor.putInt("boxTwo", boxTwoColor)
        editor.putInt("boxThree", boxThreeColor)
        editor.putInt("boxFour", boxFourColor)
        editor.putInt("boxFive", boxFiveColor)
        editor.commit()
    }

    private fun loadSavedColors(){
        boxOneColor = sharedPreferences.getInt("boxOne", boxOneColor)
        setViewBackgroundColor(box_one_text, boxOneColor)

        boxTwoColor = sharedPreferences.getInt("boxTwo", boxTwoColor)
        setViewBackgroundColor(box_two_text, boxTwoColor)

        boxThreeColor = sharedPreferences.getInt("boxThree", boxThreeColor)
        setViewBackgroundColor(box_three_text, boxThreeColor)

        boxFourColor = sharedPreferences.getInt("boxFour", boxFourColor)
        setViewBackgroundColor(box_four_text, boxFourColor)

        boxFiveColor = sharedPreferences.getInt("boxFive", boxFiveColor)
        setViewBackgroundColor(box_five_text, boxFiveColor)
    }

    private fun setColorButtonsAction() {
        button_red.setOnClickListener {
            currentColor = R.color.red
        }

        button_yellow.setOnClickListener {
            currentColor = R.color.yellow
        }

        button_green.setOnClickListener {
            currentColor = R.color.green
        }

    }

     private fun setBoxColorAction() {
         box_one_text.setOnClickListener {
            it.setBackgroundResource(currentColor)
             boxOneColor = currentColor
         }
         box_two_text.setOnClickListener {
             it.setBackgroundResource(currentColor)
             boxTwoColor = currentColor
         }
         box_three_text.setOnClickListener {
             it.setBackgroundResource(currentColor)
             boxThreeColor = currentColor
         }
         box_four_text.setOnClickListener {
             it.setBackgroundResource(currentColor)
             boxFourColor = currentColor
         }
         box_five_text.setOnClickListener {
             it.setBackgroundResource(currentColor)
             boxFiveColor = currentColor
         }
    }
    private fun setViewBackgroundColor(view: View, colorId: Int) {
        view.setBackgroundResource(colorId)
    }
}





