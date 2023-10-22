package com.example.simplecalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null;
    private var factorA: Double = 0.0;
    private var operator: String = "x";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number0Button: Button = findViewById(R.id.number0)
        number0Button.setOnClickListener { insertNumber(("0")) }
        val number1Button: Button = findViewById(R.id.number1)
        number1Button.setOnClickListener { insertNumber(("1")) }
        val number2Button: Button = findViewById(R.id.number2)
        number2Button.setOnClickListener { insertNumber(("2")) }
        val number3Button: Button = findViewById(R.id.number3)
        number3Button.setOnClickListener { insertNumber(("3")) }
        val number4Button: Button = findViewById(R.id.number4)
        number4Button.setOnClickListener { insertNumber(("4")) }
        val number5Button: Button = findViewById(R.id.number5)
        number5Button.setOnClickListener { insertNumber(("5")) }
        val number6Button: Button = findViewById(R.id.number6)
        number6Button.setOnClickListener { insertNumber(("6")) }
        val number7Button: Button = findViewById(R.id.number7)
        number7Button.setOnClickListener { insertNumber(("7")) }
        val number8Button: Button = findViewById(R.id.number8)
        number8Button.setOnClickListener { insertNumber(("8")) }
        val number9Button: Button = findViewById(R.id.number9)
        number9Button.setOnClickListener { insertNumber(("9")) }

        val ceButton: Button = findViewById(R.id.ce)
        ceButton.setOnClickListener { ce() }
        val cButton: Button = findViewById(R.id.c)
        cButton.setOnClickListener { c() }
        val bsButton: Button = findViewById(R.id.bs)
        bsButton.setOnClickListener { bs() }

        val divideButton: Button = findViewById(R.id.divide)
        divideButton.setOnClickListener { assignOperator("/") }
        val multiplyButton: Button = findViewById(R.id.multiply)
        multiplyButton.setOnClickListener { assignOperator("*") }
        val minusButton: Button = findViewById(R.id.minus)
        minusButton.setOnClickListener { assignOperator("-") }
        val plusButton: Button = findViewById(R.id.plus)
        plusButton.setOnClickListener { assignOperator("+") }

        val changeButton: Button = findViewById(R.id.change)
        changeButton.setOnClickListener { change() }
        val dotButton: Button = findViewById(R.id.dot)
        dotButton.setOnClickListener { insertNumber(".") }
        val calButton: Button = findViewById(R.id.equal)
        calButton.setOnClickListener { calculate() }

        textView = findViewById(R.id.factor)
    }

    private fun insertNumber(number: String) {
        if (textView?.text.toString().last().isDigit() || textView?.text.toString().last() == '.') {
            if (textView?.text.toString().first() == '0') {
                textView?.text = number
                return
            }
            val text = textView?.text.toString() + number
            textView?.text = text
            return
        }
        textView?.text = number
    }

    private fun ce() {
        textView?.text = "0"
    }

    private fun c() {
        textView?.text = "0"
        factorA = 0.0
    }

    private fun bs() {
        if (textView?.text.toString().length == 1) {
            textView?.text = "0"
            return
        }
        val text = textView?.text.toString().substring(0, textView?.text.toString().length - 1)
        textView?.text = text
    }

    private fun assignOperator(operator: String) {
        this.operator = operator
        if (textView?.text.toString().last().isDigit())
            factorA = textView?.text.toString().toDouble()
        textView?.text = operator
    }

    private fun calculate() {
        var result: Double = 0.0
        if (!textView?.text.toString().last().isDigit()) return
        when (operator) {
            "+" -> {
                result = factorA + textView?.text.toString().toDouble()
            }

            "-" -> {
                result = factorA - textView?.text.toString().toDouble()
            }

            "/" -> {
                if (textView?.text.toString() == "0") {
                    textView?.text = "Lỗi"
                    return
                }
                result = factorA / textView?.text.toString().toDouble()
            }

            "*" -> {
                result = factorA * textView?.text.toString().toDouble()
            }
        }
        if (result % 1 == 0.0) {
            textView?.text = result.toInt().toString()
            return
        }
        textView?.text = result.toString()
    }

    private fun change() {
        if (textView?.text.toString().toDouble() > 0) {
            var text = "-" + textView?.text.toString()
            textView?.text = text
        } else if (textView?.text.toString().toDouble() < 0) {
            var text = textView?.text.toString().substring(0, textView?.text.toString().length - 1)
            textView?.text = text
        }

    }
}