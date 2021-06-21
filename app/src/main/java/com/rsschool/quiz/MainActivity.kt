package com.rsschool.quiz

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.rsschool.quiz.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {

    private lateinit var adapter: QuizAdapter
    private lateinit var viewPager: ViewPager2


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = QuizAdapter(this)
        viewPager = binding.container
        viewPager.adapter = adapter

        binding.nextButton.setOnClickListener {
            if (viewPager.currentItem == 4) {
                openResultFragment()
            } else {
                viewPager.currentItem = viewPager.currentItem + 1
            }
        }

        binding.previousButton.setOnClickListener{
            if (viewPager.currentItem == 0) {
                onBackPressed()
            } else {
                viewPager.currentItem = viewPager.currentItem - 1
            }
        }

    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }


    fun openResultFragment() {
        val resultFragment: Fragment = ResultFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.container1.id, resultFragment)
        transaction.commit()
    }

}