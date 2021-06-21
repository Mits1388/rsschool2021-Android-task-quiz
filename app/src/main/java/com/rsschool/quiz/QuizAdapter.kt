package com.rsschool.quiz

import android.os.Bundle
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter

class QuizAdapter (fragment: FragmentActivity): FragmentStateAdapter(fragment){

    val questions = listOf<Question>(
        Question("The capitals of Belarus?", "Minsk", "Hrodna", "Vitebsk", "Mogilev","Brest", 1),
        Question("The capital of Russia?", "Magadan", "Omsk", "Saint Petersburg", "Moscow","Ufa", 4),
        Question("The capital of Ukraine?", "Lviv", "Kiev", "Simferopol", "Odesa","Uzhhorod", 2),
        Question("The capital of France?", "Marseille", "Lyon", "Saint-Étienne", "Rennes", "Paris",5),
        Question("The capital of Germany?", "Berlin", "Stuttgart", "Dewunmi", "Hamburg","Munich", 1)
    )

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = QuizFragment()
        fragment.arguments = bundleOf(
            "currentQuestion" to questions[position].currentQuestion,
            "option1" to questions[position].option1,
            "option2" to questions[position].option2,
            "option3" to questions[position].option3,
            "option4" to questions[position].option4,
            "option5" to questions[position].option5,
            "answer" to questions[position].answer,
            "position" to position+1
        )
return fragment
    }
}


