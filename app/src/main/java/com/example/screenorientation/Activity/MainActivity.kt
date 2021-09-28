package com.example.screenorientation.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.screenorientation.FragmentActivity.FragmentActivity
import com.example.screenorientation.R
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    private lateinit var viewFragment: View
    private lateinit var userName: EditText
    private lateinit var password: EditText
    private lateinit var login_buttonn: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        validation()
        }

    private fun validation() {
        userName = viewFragment.findViewById(R.id.email_name)
        password = viewFragment.findViewById(R.id.password_edit)
        login_buttonn = viewFragment.findViewById(R.id.login_button)
        login_buttonn.setOnClickListener() {
            val validation = arrayOf(userName,password)
            if(validationInfo(validation)){
                val intent:Intent
                intent = Intent(this,FragmentActivity::class.java)
                startActivity(intent)
            }
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