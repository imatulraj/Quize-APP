package com.gupta.quizeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        result_username.text=intent.getStringExtra(constants.USR_NAME)
       var correct_ans=intent.getStringExtra(constants.CORRECT_ANS)
        var total_ans=intent.getStringExtra(constants.TOTAL_QUESTION)
        result_score.text="YOUR SCORE IS ${correct_ans} OUT OF ${total_ans}"
        bu_finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}