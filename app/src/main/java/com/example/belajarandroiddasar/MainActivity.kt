package com.example.belajarandroiddasar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var sayHelloButton: Button
    private lateinit var sayHelloTextView: TextView

    private fun initComponents() {
        nameEditText = findViewById(R.id.nameEditText)
        sayHelloButton = findViewById(R.id.sayHelloButton)
        sayHelloTextView = findViewById(R.id.sayHelloTextView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        initComponents()

        sayHelloTextView.text = resources.getText(R.string.app_name)

        sayHelloButton.setOnClickListener {
            Log.i("PZN", "sayHello Button clicked!")
            val name = nameEditText.text.toString()
            sayHelloTextView.text = resources.getString(R.string.sayHelloTextView, name)

            resources.getStringArray(R.array.names).forEach {
                Log.i("PZN", it)
            }

            Log.i("PZN", resources.getInteger(R.integer.maxPaging).toString())
            Log.i("PZN", resources.getIntArray(R.array.numbers).joinToString(","))
            Log.i("PZN", resources.getBoolean(R.bool.isProductionMode).toString())
            Log.i("PZN", resources.getColor(R.color.background, theme).toString())

            sayHelloButton.setBackgroundColor(resources.getColor(R.color.background, theme))

            val json = assets.open("sample.json").bufferedReader().use { it.readText() }
            Log.i("JSON", json);

            val raw_json = resources.openRawResource(R.raw.sample).bufferedReader().use { it.readText() }
            Log.i("JSON", raw_json);
        }

    }
}