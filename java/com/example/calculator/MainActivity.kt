package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun isFloat(s: String): Boolean {
        return try {
            s.toFloat()
            true
        } catch (ex: NumberFormatException) {
            false
        }
    }

    fun onClick(v: View) {
        when(v.id) {
            R.id.button0 -> insertData("0")
            R.id.button1 -> insertData("1")
            R.id.button2 -> insertData("2")
            R.id.button3 -> insertData("3")
            R.id.button4 -> insertData("4")
            R.id.button5 -> insertData("5")
            R.id.button6 -> insertData("6")
            R.id.button7 -> insertData("7")
            R.id.button8 -> insertData("8")
            R.id.button9 -> insertData("9")

            R.id.plus -> insertData("+")
            R.id.div -> insertData("÷")
            R.id.multi -> insertData("×")
            R.id.sub -> insertData("-")
            R.id.rmv -> insertData("clear")
            R.id.rem -> insertData("%")
            R.id.dot -> insertData(".")
            R.id.result -> insertData("result")
        }
    }

    private fun clear() : String {
        findViewById<TextView>(R.id.t_view).text = ""
        return ""
    }

    private fun result(str : String) : String {
        var data = str.split(" ")

        var result = data.get(0)
            for (i in 0 .. (data.size)) {
                if( i % 2 == 1 && i != data.size  && isFloat(data.get(i + 1)) ) {
                    println(i)
                    result = when (data.get(i)) {
                        "+" -> ((result.toFloat()) + (data.get(i + 1).toFloat())).toString()
                        "-" -> ((result.toFloat()) - (data.get(i + 1).toFloat())).toString()
                        "×" -> ((result.toFloat()) * (data.get(i + 1).toFloat())).toString()
                        "÷" -> ((result.toFloat()) / (data.get(i + 1).toFloat())).toString()
                        "%" -> ((result.toFloat()) % (data.get(i + 1).toFloat())).toString()
                        else -> "수식이 잘못 되었습니다."
                    }
                }
            }

        clear()

        return result
    }

    private fun insertData(operator: String) : Unit {
        val t_view = findViewById<TextView>(R.id.t_view)

        t_view.append(when(operator) {
            "+" -> " + "
            "-" -> " - "
            "×" -> " × "
            "÷" -> " ÷ "
            "%" -> " % "
            "clear" -> clear()
            "result" -> result(t_view.text.toString())
            else -> operator
        });

    }
}