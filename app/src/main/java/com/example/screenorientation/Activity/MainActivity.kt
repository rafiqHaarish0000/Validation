package com.example.screenorientation.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.screenorientation.R
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var btnShowbottomSheet : Button
    private lateinit var userName: EditText
    private lateinit var userPass: EditText
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val userName = findViewById<EditText>(R.id.userName)
        val userPass = findViewById<EditText>(R.id.userPassword)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        btnShowbottomSheet = findViewById<Button>(R.id.bottomBtn)
        savedInstanceState?.let {
            userPass.setText("pass")
        }


        loginBtn.setOnClickListener{
            val text = userName.text
            val pass = userPass.text

            if(text.isEmpty()){
                userName.error = "Invalid username"
            }else if(pass.isEmpty()){
                userPass.error = "Invalid user password"
            }else if(!getText(userPass)){
                userPass.error = "must contains 7 characters"
            }
            else{
                Toast.makeText(this, "Welcome $text",Toast.LENGTH_SHORT).show()
            }
        }
        btnShowbottomSheet.setOnClickListener{
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Alert")
            dialog.setMessage("Rotate your screen to landscape")
            dialog.show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val name = userName.toString()
        val pass = userPass.toString()
        outState.putString("name",name)
        outState.putString("pass",pass)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.get("name")
        savedInstanceState.get("pass")
    }


    private fun getText(editText: EditText): Boolean {
        var validate = true;
        val getData = editText.toString()
        val passValidation = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])/"
        val pattern = Pattern.compile(passValidation)
        val matcher = pattern.matcher(getData)
        if(!matcher.matches()){
            validate = false
        }
        return validate
    }

}