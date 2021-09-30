package com.example.screenorientation.FragmentClass

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.example.screenorientation.R
import com.google.android.material.internal.NavigationMenuItemView
import kotlin.reflect.typeOf

internal val TAG = ClassFragments::class.java.canonicalName

class ClassFragments : Fragment() {
    private lateinit var viewFragment: View
    lateinit var createOne:TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        viewFragment = inflater.inflate(R.layout.first_fragment, container, false)
        validation()
        return viewFragment
    }

    companion object {
        fun getInstance(): ClassFragments {
            return ClassFragments()
        }
    }

    private fun toast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    private fun validation() {
        createOne = viewFragment.findViewById(R.id.createOne)
        createOne.setOnClickListener(){
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView2,SecondFragment.getSecondInstance())
                .commit()
        }

    }
    private fun validationInfo(validation:Array<EditText>):Boolean{
        var flag = true
        for(item in validation){
            if(item.text.toString().isEmpty()){
                item.error = "field required"
                flag = false
            }
        }
        return flag
    }

}