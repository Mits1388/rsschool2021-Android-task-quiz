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

//не удалять
    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
   //  private var i = 0

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

            }

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
          if(checkedId == binding.optionOne.id){
            //Toast.makeText(activity, binding.optionOne.text.toString(), Toast.LENGTH_SHORT).show()
             i++
          // Toast.makeText(activity, i.toString(), Toast.LENGTH_SHORT).show()
              SaveIntoSharedPrefs("TAG_NAME", i)
          }

       /*   else if(checkedId == binding.optionTwo.id){
            Toast.makeText(activity, binding.optionTwo.text.toString(), Toast.LENGTH_SHORT).show()
        }else if(checkedId == binding.optionThree.id){
            Toast.makeText(activity, binding.optionThree.text.toString(), Toast.LENGTH_SHORT).show()
        }else if(checkedId == binding.optionFour.id){
            Toast.makeText(activity, binding.optionFour.text.toString(), Toast.LENGTH_SHORT).show()
        }else if(checkedId == binding.optionFive.id){
            Toast.makeText(activity, binding.optionFive.text.toString(), Toast.LENGTH_SHORT).show()
        }
       */
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




    }

