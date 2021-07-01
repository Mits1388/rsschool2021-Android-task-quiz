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

        binding.finishText.text ="Your result is ${arguments?.getInt("answer").toString()} out of 5"

        binding.closeButton.setOnClickListener {
            activity?.finish()
        }

    }


    private fun onStartQuizFragment() {
        val fragment: Fragment = QuizFragment()
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment).commit()
    }



    companion object {
        @JvmStatic
        fun newInstance(answer: Array<Int>): ResultFragment {
            val fragment = ResultFragment()
            val args = Bundle()
            args.putInt(ANSWER, answer.sum())
            fragment.arguments = args
            return fragment
        }
        private const val ANSWER = "answer"
    }
}
