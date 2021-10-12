package com.example.learner.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.learner.R
import com.example.learner.util.AppConstants
import com.example.learner.util.AppSessions
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignupFragment : Fragment() {
    private lateinit var viewFragment: View
    private lateinit var edt_firstName: EditText
    private lateinit var edit_lastName: EditText
    private lateinit var email_edit: EditText
    private lateinit var mobileNumber_edt: EditText
    private lateinit var password_edt: EditText
    private lateinit var confirm_password_edt: EditText
    private lateinit var signupButton: Button
    private lateinit var checkText: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewFragment = inflater.inflate(R.layout.signup, container, false)
        validation()
        return viewFragment
    }

    private fun validation() {
        edt_firstName = viewFragment.findViewById(R.id.edt_firstname)
        edit_lastName = viewFragment.findViewById(R.id.edt_lastName)
        email_edit = viewFragment.findViewById(R.id.edt_email)
        mobileNumber_edt = viewFragment.findViewById(R.id.edt_mobileNumber)
        password_edt = viewFragment.findViewById(R.id.edt_password)
        checkText = viewFragment.findViewById(R.id.errorText)
        confirm_password_edt = viewFragment.findViewById(R.id.edt_confirmPassword)
        signupButton = viewFragment.findViewById(R.id.signUp_button)

        val validation = arrayOf(
            edt_firstName,
            edit_lastName,
            edit_lastName,
            email_edit,
            mobileNumber_edt,
            password_edt,
            confirm_password_edt
        )

        //onClick
        signupButton.setOnClickListener {

            if (isDetailsEmpty(validation))
                if (validationinfo()) {
                    putData()
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView2, LoginFragment.getInstance())
                        .commit()

                } else {
                    Log.i(TAG, "validation: dskfgdsgf")
                }
        }

    }

    private fun validationinfo(): Boolean {

        var flag = true
        if (!isEmailMatch(email_edit.text.toString())) {
            email_edit.error = "Invalid fields"
            flag = false
        }

        if (!isPasswordMatch(password_edt.text.toString())) {
            checkText.visibility = View.VISIBLE
            flag = false
        } else {
            checkText.visibility = View.GONE
        }


        if (!isMobileNumberMatch(mobileNumber_edt.text.toString())) {
            mobileNumber_edt.error = "Enter valid mobile number"
            flag = false
        }

        if (password_edt.text.toString() != confirm_password_edt.text.toString()) {
            confirm_password_edt.error = "password mismatched"
            flag = false
        }

        return flag
    }

    private fun isDetailsEmpty(validation: Array<EditText>): Boolean {
        var flag = true
        for (item in validation) {
            if (item.text.isEmpty()) {
                item.error = "Details required"
                Log.i(TAG, "item: $item")
                flag = false
            }
        }
        return flag
    }

    private fun isEmailMatch(str: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(str).matches()
    }

    private fun isPasswordMatch(str: String): Boolean {
        val pattern: Pattern
        val PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%!\\-_?&])(?=\\S+\$).{8,}")
        pattern = PASSWORD_PATTERN
        val matcher: Matcher = pattern.matcher(str)
        return matcher.matches()
    }

    private fun isMobileNumberMatch(str: String): Boolean {
        val pattern: Pattern
        val NumberValidation =
            Pattern.compile("[0-9]{10}")
        pattern = NumberValidation
        val matcher: Matcher = pattern.matcher(str)
        return matcher.matches()

    }

    private fun putData() {

        val username: String = email_edit.text.toString()
        val password: String = password_edt.text.toString()
        val firstname: String = edt_firstName.text.toString()
        val lastname: String = edit_lastName.text.toString()
        val mobilenumber: String = mobileNumber_edt.text.toString()
        val confirmpassword: String = confirm_password_edt.text.toString()

        AppSessions.setFirstName(
            AppConstants.Preference.Key.FIRSTNAME_KEY,
            firstname,
            requireContext()
        )
        AppSessions.setLastName(
            AppConstants.Preference.Key.LASTNAME_KEY,
            lastname,
            requireContext()
        )
        AppSessions.setMobilenumber(
            AppConstants.Preference.Key.MOBILENUMBER_KEY,
            mobilenumber,
            requireContext()
        )
        AppSessions.setConfirmpassword(
            AppConstants.Preference.Key.CONFIRMPASSWORD_KEY,
            confirmpassword,
            requireContext()
        )

        AppSessions.setSession(AppConstants.Preference.Key.USERNAME_KEY, username, requireContext())
        AppSessions.setSession(AppConstants.Preference.Key.PASSWORD_KEY, password, requireContext())

    }


    companion object {
        fun getInstance(): SignupFragment {
            return SignupFragment()
        }
    }
}

