package com.example.screenorientation.FragmentClass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.screenorientation.R

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.second_fragment, container, false)
        return view

    }
    companion object {
        fun getSecondInstance(): SecondFragment {
            return SecondFragment()
        }
    }


}