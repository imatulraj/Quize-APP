package com.gupta.quizeapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions.*

class Questions : AppCompatActivity(),View.OnClickListener {
    var list=ArrayList<question>()
    var currentquesid=1
    var selctedoption=0
    var correctans=0
    var username:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        list= constants.Question()
        setQuestion()
        var b:Bundle=intent.extras!!
         username=b.getString(constants.USR_NAME)
        currentquesid=1
        ques_option1.setOnClickListener(this)
        ques_option2.setOnClickListener(this)
        ques_option3.setOnClickListener(this)
        ques_option4.setOnClickListener(this)
        bu_submit.setOnClickListener(this)
    }
    private fun setQuestion() {
        defaulButtom()
        if(currentquesid==list.size){
            bu_submit.setText("FINISH")
        }
        else
        {
            bu_submit.setText("SUBMIT")
        }
        var CurrentQuest=list[currentquesid-1]
        ques_progess.progress=currentquesid
        ques_pprogress_text.text = "$currentquesid/10"
        ques_Question.text = CurrentQuest!!.ques
        ques_flag.setImageResource(CurrentQuest!!.image)
        ques_option1.text=CurrentQuest!!.op1
        ques_option2.text=CurrentQuest!!.op2
        ques_option3.text=CurrentQuest!!.op3
        ques_option4.text=CurrentQuest!!.op4
    }
    private fun defaulButtom(){
        var optionBu=ArrayList<TextView>()
        optionBu.add(0,ques_option1)
        optionBu.add(1,ques_option2)
        optionBu.add(2,ques_option3)
        optionBu.add(3,ques_option4)
        for(op in optionBu)
        {
            op.typeface=Typeface.DEFAULT
            op.setTextColor(Color.parseColor("#7A8089"))
            op.setBackgroundResource(R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.ques_option1 ->{

                selctionOptionchange(ques_option1,1)
            }
            R.id.ques_option2 ->{
                selctionOptionchange(ques_option2,2)
            }
            R.id.ques_option3 ->{

                selctionOptionchange(ques_option3,3)
             }
            R.id.ques_option4 ->{
                   selctionOptionchange(ques_option4,4)
            }
            R.id.bu_submit -> {
                if (selctedoption == 0) {
                    ++currentquesid
                    if (currentquesid <= list.size) {
                        setQuestion()
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "YAAH COMPLETED THE QUIZE",
                            Toast.LENGTH_SHORT
                        ).show()
                        var intent=Intent(this,Result::class.java)
                        intent.putExtra(constants.USR_NAME,username)
                        intent.putExtra(constants.CORRECT_ANS, correctans.toString())
                        intent.putExtra(constants.TOTAL_QUESTION, list.size.toString())

                        startActivity(intent)
                        finish()
                    }
                } else {
                    var q = list[currentquesid - 1]
                    if (selctedoption != q.COp) {
                        ansverView(selctedoption, R.drawable.wrong_option_border_bg)
                    }else
                    {
                        correctans++
                    }
                    Toast.makeText(applicationContext, "SELECTED OPTION : $selctedoption", Toast.LENGTH_SHORT).show()
                    ansverView(q.COp, R.drawable.correct_option_border_bg)
                    if (currentquesid < list.size) {
                        bu_submit.setText("NEXT QUESTION")
                    } else {
                        bu_submit.setText("FINISH")
                    }
                    selctedoption = 0
                }
            }
        }
    }

    private fun ansverView(buttonId: Int, DrawbleInt: Int) {
            when(buttonId){
                1->{
                    ques_option1.setBackgroundResource(DrawbleInt)
                }
                2->{
                    ques_option2.setBackgroundResource(DrawbleInt)
                }
                3->{
                    ques_option3.setBackgroundResource(DrawbleInt)
                }
                4->{
                    ques_option4.setBackgroundResource(DrawbleInt)
                }
            }
    }

    fun selctionOptionchange(tv:TextView,id:Int){
        defaulButtom()
        selctedoption=id
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.setBackgroundResource(R.drawable.selected_option_border_bg)

    }
}