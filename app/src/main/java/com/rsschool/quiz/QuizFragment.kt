package com.rsschool.quiz


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.rsschool.quiz.databinding.FragmentQuizBinding
import com.rsschool.quiz.databinding.FragmentQuizViewPagerBinding


class QuizFragment : Fragment() {

    var answers = mutableListOf( 0, 0, 0, 0, 0)

    private var _binding: FragmentQuizViewPagerBinding? = null
    private val binding get() = _binding!!


    val questions = listOf<Question>(
        Question(
            "The capitals of Belarus?",
            "Minsk",
            "Hrodna",
            "Vitebsk",
            "Mogilev",
            "Brest",
            1,
            R.style.Theme_Quiz_One
        ),
        Question(
            "The capital of Russia?",
            "Magadan",
            "Omsk",
            "Saint Petersburg",
            "Moscow",
            "Ufa",
            4,
            R.style.Theme_Quiz_Two
        ),
        Question(
            "The capital of Ukraine?",
            "Lviv",
            "Kiev",
            "Simferopol",
            "Odesa",
            "Uzhhorod",
            2,
            R.style.Theme_Quiz_Three
        ),
        Question(
            "The capital of France?",
            "Marseille",
            "Lyon",
            "Saint-Étienne",
            "Rennes",
            "Paris",
            5,
            R.style.Theme_Quiz_Four
        ),
        Question(
            "The capital of Germany?",
            "Berlin",
            "Stuttgart",
            "Dewunmi",
            "Hamburg",
            "Munich",
            1,
            R.style.Theme_Quiz
        )
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
        viewPager.adapter = MyViewPagerAdapter(viewPager)
        viewPager.isUserInputEnabled = false
        viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })
    }
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


    inner class MyViewPagerAdapter(private val viewPager: ViewPager2) :
        RecyclerView.Adapter<MyViewPagerAdapter.MyViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(FragmentQuizBinding.inflate(layoutInflater, parent, false))
        }

        override fun getItemCount() = questions.size

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            with(holder){
                binding.toolbar.title =  "Question ${position+1}"
                binding.question.text = questions[position].currentQuestion
                binding.optionOne.text = questions[position].option1
                binding.optionTwo.text =  questions[position].option2
                binding.optionThree.text =  questions[position].option3
                binding.optionFour.text =  questions[position].option4
                binding.optionFive.text =  questions[position].option5
                binding.fragmentQuiz.context?.theme?.applyStyle(questions[position].theme, true)

                if (position == 0) {
                    binding.toolbar.navigationIcon = null
                    binding.previousButton.isEnabled = false
                }

                if (position == questions.size - 1) binding.nextButton.text = "Submit"

                binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
                    binding.nextButton.isEnabled = true
                    when (checkedId) {

                        binding.optionOne.id -> {
                            if (questions[position].answer.equals(1)) {
                                answers[position] = 1
                            }else{
                                answers[position] = 0
                            }
                        }
                        binding.optionTwo.id -> {
                            if (questions[position].answer.equals(2)) {
                                answers[position] = 1
                            }else{
                                answers[position] = 0
                            }
                        }
                        binding.optionThree.id -> {
                            if (questions[position].answer.equals(3)) {
                                answers[position] = 1
                            }else{
                                answers[position] = 0
                            }
                        }
                        binding.optionFour.id -> {
                            if (questions[position].answer.equals(4)) {
                                answers[position] = 1
                            }else{
                                answers[position] = 0
                            }
                        }
                        binding.optionFive.id -> {

                            if (questions[position].answer.equals(5)) {
                                answers[position] = 1
                            }else{
                                answers[position] = 0
                            }
                        }
                    }
                }

                binding.nextButton.setOnClickListener {
                    if (position == questions.size - 1) {
                        openResultFragment(answers.toTypedArray())
                    } else {
                        viewPager.currentItem = position + 1
                    }
                }

                binding.previousButton.setOnClickListener {
                    viewPager.currentItem = position - 1
                }

                binding.toolbar.setNavigationOnClickListener {
                    viewPager.currentItem = position - 1
                }

            }
        }


        inner class MyViewHolder(val binding: FragmentQuizBinding) :
            RecyclerView.ViewHolder(binding.root)
    }


    private fun openResultFragment(answer: Array<Int>) {
        val resultFragment: Fragment = ResultFragment.newInstance(answer)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, resultFragment)
        transaction.commit()

    }
}


