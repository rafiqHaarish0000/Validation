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
    private lateinit var userName: EditText
    private lateinit var password: EditText
    private lateinit var login_buttonn: Button
    private lateinit var signUpButton:Button

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
        userName = viewFragment.findViewById(R.id.email_name)
        password = viewFragment.findViewById(R.id.password_edit)
        login_buttonn = viewFragment.findViewById(R.id.login_button)
        signUpButton = viewFragment.findViewById(R.id.first_Signup)
        //onClick..
        login_buttonn.setOnClickListener() {
         val validation = arrayOf(userName,password)
            if(validationInfo(validation)){

            }
        }
        signUpButton.setOnClickListener(){
        var nav:NavigationMenuItemView
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