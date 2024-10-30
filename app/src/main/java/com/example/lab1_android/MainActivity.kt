package com.example.lab1_android

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private val textKey = "text_key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        val changeTextButton = findViewById<Button>(R.id.myButton)


        if (savedInstanceState != null) {
            val savedText = savedInstanceState.getString(textKey, getString(R.string.custom_text))
            textView.text = savedText
        }


        changeTextButton.setOnClickListener {
            textView.text = "Why this does`n`n`t work"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(textKey, textView.text.toString())
    }
}
