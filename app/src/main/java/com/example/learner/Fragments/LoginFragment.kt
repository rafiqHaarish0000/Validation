package com.example.learner.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.learner.R
import com.example.learner.util.AppConstants
import com.example.learner.util.AppSessions
import java.util.regex.Matcher
import java.util.regex.Pattern

class LoginFragment : Fragment() {

    private lateinit var viewFragment: View
    private lateinit var editUsername: EditText
    private lateinit var editPassword: EditText
    private lateinit var mLoginButton: Button
    private lateinit var mSignupButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewFragment = inflater.inflate(R.layout.login, container, false)
        editUsername = viewFragment.findViewById(R.id.userName)
        editPassword = viewFragment.findViewById(R.id.user_password)
        mLoginButton = viewFragment.findViewById(R.id.login_button)
        mSignupButton = viewFragment.findViewById(R.id.first_Signup)
        validation()
        return viewFragment
    }


    //onclick event..
    private fun validation() {

        mLoginButton.setOnClickListener() {
            if (validationInfo()) {
                if (getData()) {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2, HomeFragment.getInstance())
                        .commit()
                }
            } else {
                Toast.makeText(requireContext(), "Please check the details", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        mSignupButton.setOnClickListener() {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView2, SignupFragment.getInstance())
                .commit()
        }
    }


    //validation edittext
    private fun validationInfo(): Boolean {
        var flag = true

        if (editUsername.text.toString().isEmpty()) {
            editUsername.error = "Invalid username"
            flag = false
        }

        if (editPassword.text.toString().isEmpty()) {
            editPassword.error = "Invalid password"
            flag = false
        }

        if(!isEmailMatch(editUsername.text.toString())){
            editUsername.error = "Enter valid email"
            flag = false
        }

        if(!isPasswordMatch(editPassword.text.toString())){
            editPassword.error = "Enter valid password"
            flag = false
        }

        return flag
    }

    //verify email
    private fun isEmailMatch(str: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(str).matches()
    }

    //verify password
    private fun isPasswordMatch(str: String): Boolean {
        val pattern: Pattern
        val PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%!\\-_?&])(?=\\S+\$).{8,}")
        pattern = PASSWORD_PATTERN
        val matcher: Matcher = pattern.matcher(str)
        return matcher.matches()
    }

    //check and store data from signup page
    private fun getData(): Boolean {

        val editUser: String = editUsername.text.toString()

        val sessionUserName = AppSessions.getSession(
            AppConstants.Preference.Key.USERNAME_KEY,
            requireContext()
        )

        val editPassword: String = editPassword.text.toString()

        val sessionPassword = AppSessions.getSession(
            AppConstants.Preference.Key.PASSWORD_KEY,
            requireContext()
        )
        return (editUser.equals(sessionUserName, ignoreCase = false)
                && editPassword.equals(sessionPassword, ignoreCase = false))
    }


    companion object {
        fun getInstance(): LoginFragment {
            return LoginFragment()
        }
    }
}