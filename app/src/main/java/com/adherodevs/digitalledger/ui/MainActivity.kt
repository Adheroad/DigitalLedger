package com.adherodevs.digitalledger.ui

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.drawerlayout.widget.DrawerLayout
import com.adherodevs.digitalledger.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val floatingActionButton: AppCompatImageButton = findViewById(R.id.floatingActionButton)
        val dynamicContainer = findViewById<LinearLayout>(R.id.dynamicContainer)
        val options: ImageView = findViewById(R.id.options)

        // Drawer
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)

        options.setOnClickListener {
            drawerLayout.openDrawer(navigationView)
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_profile -> {
                    Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.menu_settings -> {
                    Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.menu_logout -> {
                    Toast.makeText(this, "Logout clicked", Toast.LENGTH_SHORT).show()
                }
            }
            drawerLayout.closeDrawers()
            true
        }

        floatingActionButton.setOnClickListener {
            if (dynamicContainer == null) {
                Log.e("MainActivity", "LinearLayout dynamicContainer not found!")
                return@setOnClickListener
            }

            val newTextView = TextView(this)
            newTextView.text = "Dummy Addition"
            newTextView.textSize = 18f

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            newTextView.layoutParams = params
            dynamicContainer.addView(newTextView)
        }
    }
}
