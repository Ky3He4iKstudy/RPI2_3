package dev.ky3he4ik.pract3_3

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun moodChange(v: View) {
        findViewById<ImageView>(R.id.mood).apply {
            when (v.id) {
                R.id.good -> setImageResource(R.drawable.cheerful)
                R.id.bad -> setImageResource(R.drawable.cry)
            }
        }
    }

    fun record(v: View) {
        val event_t = findViewById<EditText>(R.id.vevent).text
        val time_t = findViewById<EditText>(R.id.time).text
        val date_t = findViewById<EditText>(R.id.vdata).text
        val note_t = findViewById<EditText>(R.id.post).text
        val string = "Записано!\nСобытие: $event_t\nДата: $date_t\nВремя: $time_t\nЗаметки: $note_t"
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
        event_t.clear()
        time_t.clear()
        date_t.clear()
        note_t.clear()
    }
}