package com.rsschool.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.rsschool.quiz.databinding.ActivityMainBinding


class MainActivity : FragmentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val quizFragment: Fragment = QuizFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.container.id, quizFragment)
        transaction.commit()
    }
}



