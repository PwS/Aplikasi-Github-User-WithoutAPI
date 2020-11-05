package com.pws.dicodingsubmission

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by PwS
 */

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
       setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed(object : Runnable {
            override fun run() {
                val i = Intent(this@SplashScreen, MainActivity::class.java)
                startActivity(i) // menghubungkan activity splashscren ke main activity dengan intent

                //jeda selesai Splashscreen
                this.finish()
            }

            private fun finish() {}
        }, splashInterval.toLong())
    }

    companion object {
        //SatuanDetik
        private const val splashInterval = 2000
    }
}