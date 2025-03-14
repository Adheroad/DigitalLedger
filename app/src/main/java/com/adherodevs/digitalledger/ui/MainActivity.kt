package com.adherodevs.digitalledger.ui

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import com.adherodevs.digitalledger.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val floatingActionButton: AppCompatImageButton = findViewById(R.id.floatingActionButton)
        val dynamicContainer = findViewById<LinearLayout?>(R.id.dynamicContainer)

        // Ensure the floating action button is found
        if (floatingActionButton == null) {
            Log.e("MainActivity", "FloatingActionButton not found!")
        }

        floatingActionButton.setOnClickListener {
            // Get the LinearLayout where the TextView will be added

            // Ensure dynamicContainer is not null
            if (dynamicContainer == null) {
                Log.e("MainActivity", "LinearLayout dynamicContainer not found!")
                return@setOnClickListener
            }

            // Create a new TextView dynamically
            val newTextView = TextView(this)
            newTextView.text = "Dummy Addition"
            newTextView.textSize = 18f

            // Set layout parameters (important for the TextView to be displayed correctly)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            newTextView.layoutParams = params

            // Add the TextView to the LinearLayout
            dynamicContainer.addView(newTextView)
        }
    }
}
