package com.rsschool.quiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.databinding.FragmentResultBinding


class ResultFragment : Fragment(R.layout.fragment_result) {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            questionOne.text = "The capitals of Belarus?"
            answerOne.text = "answer: ${arguments?.getStringArrayList("option")?.get(0)}"
            questionTwo.text = "The capital of Russia?"
            answerTwo.text = "answer: ${arguments?.getStringArrayList("option")?.get(1)}"
            questionThree.text = "The capital of Ukraine?"
            answerThree.text = "answer: ${arguments?.getStringArrayList("option")?.get(2)}"
            questionFour.text = "The capital of France?"
            answerFour.text = "answer: ${arguments?.getStringArrayList("option")?.get(3)}"
            questionFive.text = "The capital of Germany?"
            answerFive.text = "answer: ${arguments?.getStringArrayList("option")?.get(4)}"
            finishText.text = "Your result is ${arguments?.getInt("answer").toString()} out of 5"
            closeButton.setOnClickListener {
            activity?.finish()
        }
    }
    }

    companion object {
        @JvmStatic
        fun newInstance(answer: Array<Int>, optionString: ArrayList<String>): ResultFragment {
            val fragment = ResultFragment()
            val args = Bundle()
            args.putInt(ANSWER, answer.sum())
            args.putStringArrayList(OPTION, optionString)
            fragment.arguments = args
            return fragment
        }
        private const val OPTION = "option"
        private const val ANSWER = "answer"
    }
}
