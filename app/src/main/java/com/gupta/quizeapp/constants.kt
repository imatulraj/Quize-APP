package com.gupta.quizeapp
//var id:Int,
//var ques:String,
//var image:Int,
//var op1:String,
//var op2:String,
//var op3:String,
//var op4:String,
//var COp:Int,
 object constants {
     const val USR_NAME="USERNAME"
    const val CORRECT_ANS="CORRECT_ANSWER"
    const val TOTAL_QUESTION="TOTAL_QUESTION"
    fun Question():ArrayList<question>{
        var listofques=ArrayList<question>()

        listofques.add(question(1,
            "which countary flag it is?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Belgium",
            "Brazil",
            1
        ))
        listofques.add(question(2,
            "which countary flag it is?",
            R.drawable.ic_flag_of_australia,
            "Fijit",
            "Australia",
            "Germany",
            "Brazil",
            2
        ))
        listofques.add(question(3,
            "which countary flag it is?",
            R.drawable.ic_flag_of_belgium,
            "Argentina",
            "Australia",
            "Belgium",
            "Brazil",
            3
        ))
        listofques.add(question(4,
            "which countary flag it is?",
            R.drawable.ic_flag_of_brazil,
            "Argentina",
            "Australia",
            "Belgium",
            "Brazil",
            4
        ))
        listofques.add(question(5,
            "which countary flag it is?",
            R.drawable.ic_flag_of_denmark,
            "Denmark",
            "Fijit",
            "Germany",
            "India",
            1
        ))
        listofques.add(question(6,
            "which countary flag it is?",
            R.drawable.ic_flag_of_fiji,
            "Denmark",
            "Fijit",
            "Germany",
            "India",
            2
        ))
        listofques.add(question(7,
            "which countary flag it is?",
            R.drawable.ic_flag_of_germany,
            "Denmark",
            "Fijit",
            "Germany",
            "India",
            3
        ))
        listofques.add(question(8,
            "which countary flag it is?",
            R.drawable.ic_flag_of_india,
            "Denmark",
            "Fijit",
            "Germany",
            "India",
            4
        ))
        listofques.add(question(9,
            "which countary flag it is?",
            R.drawable.ic_flag_of_kuwait,
            "kuwait",
            "New Zealand",
            "Belgium",
            "Brazil",
            1
        ))
        listofques.add(question(10,
            "which countary flag it is?",
            R.drawable.ic_flag_of_new_zealand,
            "kuwait",
            "New Zealand",
            "Belgium",
            "Brazil",
            2
        ))
     return listofques
    }
}