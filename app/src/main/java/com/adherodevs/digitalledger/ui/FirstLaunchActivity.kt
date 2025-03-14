package com.adherodevs.digitalledger.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.adherodevs.digitalledger.R

class FirstLaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_launch)

        Handler().postDelayed({
            val intent = Intent(this@FirstLaunchActivity, MainActivity::class.java)
            startActivity(intent)

            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

            finish()
        }, 1000)
    }
}
