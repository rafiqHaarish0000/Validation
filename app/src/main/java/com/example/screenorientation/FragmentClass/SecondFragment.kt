package com.example.screenorientation.FragmentClass

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
import com.example.screenorientation.R

class SecondFragment : Fragment() {
    lateinit var viewFragment: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewFragment = inflater.inflate(R.layout.second_fragment, container, false)
        checkValidation()
        return viewFragment
    }

    companion object {
        fun getSecondInstance(): SecondFragment {
            return SecondFragment()
        }
    }

    private fun checkValidation() {
        val firstName: EditText = viewFragment.findViewById(R.id.edt_fullName)
        val lastName: EditText = viewFragment.findViewById(R.id.edt_lastName)
        val email: EditText = viewFragment.findViewById(R.id.edt_email)
        val mobileNumber: EditText = viewFragment.findViewById(R.id.edt_mobileNumber)
        val password: EditText = viewFragment.findViewById(R.id.edt_password)
        val confirmPassword: EditText = viewFragment.findViewById(R.id.edt_confirmPassword)

        val signUpBtn: Button = viewFragment.findViewById(R.id.signUp_button)
        signUpBtn.setOnClickListener {
            val validation =
                arrayOf(lastName, firstName, mobileNumber, email, password, confirmPassword)
            if (validateInputField(validation)) {
                Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
            } else {
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

    }

    private fun validateInputField(validation: Array<EditText>): Boolean {
        var flag = true
        for (item in validation) {
            if (item.text.toString().isEmpty()) {
                item.error = "Field Required"
                flag = false
            }
        }

        return flag
    }

    private fun toast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

}
