package com.gupta.quizeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        bu_start.setOnClickListener {
            if(et_name.text.toString().isEmpty())
            {
                Toast.makeText(this, "ENTER NAME", Toast.LENGTH_SHORT).show()
            }
            else
            {
                var intent=Intent(this,Questions::class.java)
                intent.putExtra(constants.USR_NAME,et_name.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}