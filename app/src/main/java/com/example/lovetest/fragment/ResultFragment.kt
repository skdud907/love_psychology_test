package com.example.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.example.lovetest.R
import kotlinx.android.synthetic.main.fragment_result.*
import kotlinx.android.synthetic.main.fragment_selection.*

class ResultFragment : Fragment() {
    var option = -1

    lateinit var navController : NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //만약에 option 값이 null이면 -1을 반환하겠다.
        option = arguments?.getInt("index")?:-1

        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        setResult(option)

        btn_home.setOnClickListener {
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }
    }

    fun setResult(option : Int) {
        when(option) {
            1 -> {
                tv_main.text = getString(R.string.result1)
                tv_sub.text = getString(R.string.result_detail1)
            }
            2 -> {
                tv_main.text = getString(R.string.result2)
                tv_sub.text = getString(R.string.result_detail2)
            }
            3 -> {
                tv_main.text = getString(R.string.result3)
                tv_sub.text = getString(R.string.result_detail3)
            }
            4 -> {
                tv_main.text = getString(R.string.result4)
                tv_sub.text = getString(R.string.result_detail4)
            }
        }
    }
}