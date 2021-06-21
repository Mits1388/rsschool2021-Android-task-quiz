package com.rsschool.quiz


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.rsschool.quiz.databinding.FragmentQuizBinding

 var i = 0

class QuizFragment : Fragment() {


    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentQuizBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    arguments?.let {
        binding.toolbar.title = "Question ${it.getInt("position")}"
        binding.question.text = it.getString("currentQuestion")
        binding.optionOne.text = it.getString("option1")
        binding.optionTwo.text = it.getString("option2")
        binding.optionThree.text = it.getString("option3")
        binding.optionFour.text = it.getString("option4")
        binding.optionFive.text = it.getString("option5")
       // arguments?.getInt("answer")

            }

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
          if(checkedId == binding.optionOne.id){
          if(arguments?.getInt("answer")?.equals(1) == true) {
                  i++
              //    Toast.makeText(activity,arguments?.getInt("answer").toString(),Toast.LENGTH_SHORT).show()
              }

          }else if(checkedId == binding.optionTwo.id){
              if(arguments?.getInt("answer")?.equals(2) == true) {
                  i++
                //  Toast.makeText(activity,arguments?.getInt("answer").toString(),Toast.LENGTH_SHORT).show()
              }
          }else if(checkedId == binding.optionThree.id){
              if(arguments?.getInt("answer")?.equals(3) == true) {
                  i++
                //  Toast.makeText(activity,arguments?.getInt("answer").toString(),Toast.LENGTH_SHORT).show()
              }
          }else if(checkedId == binding.optionFour.id){
              if(arguments?.getInt("answer")?.equals(4) == true) {
                  i++
                //  Toast.makeText(activity,arguments?.getInt("answer").toString(),Toast.LENGTH_SHORT).show()
              }
          }else if(checkedId == binding.optionFive.id){
              if(arguments?.getInt("answer")?.equals(5) == true) {
                  i++
                //  Toast.makeText(activity,arguments?.getInt("answer").toString(),Toast.LENGTH_SHORT).show()
              }
          }
            SaveIntoSharedPrefs("TAG_NAME", i)
        }

        }

   private fun SaveIntoSharedPrefs(key: String, value: Int) {
       val sharedpreferences: SharedPreferences
       val MyPREFERENCES = "MyPrefs"
       sharedpreferences = activity?.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)!!
       val editor = sharedpreferences.edit()
       editor.putInt(key, value)
       editor.commit()
    }

  /*  override fun onAttach(context: Context) {
        super.onAttach(context)

    }*/



    }

