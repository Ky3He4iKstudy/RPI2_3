package dev.ky3he4ik.pract3_2

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.inspect).setOnClickListener {
            var isGood = false
            do {
                val km = findViewById<EditText>(R.id.km).text.toString().toDoubleOrNull() ?: break
                val m = findViewById<EditText>(R.id.m).text.toString().toDoubleOrNull() ?: break
                val dm = findViewById<EditText>(R.id.dm).text.toString().toDoubleOrNull() ?: break
                val sm = findViewById<EditText>(R.id.sm).text.toString().toDoubleOrNull() ?: break
                val mm = findViewById<EditText>(R.id.mm).text.toString().toDoubleOrNull() ?: break

                isGood = eq(km * 1000, m) && eq(m * 10, dm) && eq(dm * 10, sm) && eq(sm * 10, mm)
            } while (false)
            findViewById<ImageView>(R.id.answer).apply {
                if (isGood)
                    setImageResource(R.drawable.cool)
                else
                    setImageResource(R.drawable.bad)
            }
            findViewById<TextView>(R.id.result).apply {
                if (isGood) {
                    text = getString(R.string.good)
                    setTextColor(Color.BLUE)
                } else {
                    text = getString(R.string.bad)
                    setTextColor(Color.RED)
                }
            }
        }
        findViewById<ImageView>(R.id.answer).apply {
            setOnClickListener {
                if (alpha < 0.1f)
                    alpha = 1f
                else
                    alpha -= 0.1f
            }
        }
    }

    private fun eq(x1: Double, x2: Double, eps: Double = 1e-9): Boolean {
        return abs(x1 - x2) < eps
    }
}