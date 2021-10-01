package com.example.screenorientation.FragmentClass

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.screenorientation.AlertBox.ClassAlertList
import com.example.screenorientation.R

class SecondFragment : Fragment() {
    lateinit var viewFragment: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewFragment = inflater.inflate(R.layout.second_fragment, container, false)
//        checkValidation()
        return viewFragment
    }

    companion object {
        fun getSecondInstance(): SecondFragment {
            return SecondFragment()
        }
    }

    private fun checkValidation() {
//        val mCompanyName: EditText = viewFragment.findViewById(R.id.company_name)
//        val mPhoneNumber: EditText = viewFragment.findViewById(R.id.phone_number)
//        val mOfficeAddress: EditText = viewFragment.findViewById(R.id.officeAddress)
//        val mOfficeCity: EditText = viewFragment.findViewById(R.id.officeCity)
//        val mOfficeState: EditText = viewFragment.findViewById(R.id.officeState)
//        val mPostalCode: EditText = viewFragment.findViewById(R.id.postalCode)
//        val mBackimage:ImageButton = viewFragment.findViewById(R.id.backImage)
//        val mSendBtn: Button = viewFragment.findViewById(R.id.sendButton)
//        val mSelectText:TextView = viewFragment.findViewById(R.id.spinner_select)
//        mSendBtn.setOnClickListener {
//            val validation =
//                arrayOf(mCompanyName, mPhoneNumber, mOfficeAddress, mOfficeCity, mOfficeState, mPostalCode)
//            if (validateInputField(validation)) {
//                toast("Success")
//            }
//        }
//        mBackimage.setOnClickListener(){
//            requireActivity().supportFragmentManager.beginTransaction()
//                .replace(R.id.fragmentContainerView2,ClassFragments.getInstance())
//                .commit()
//        }
//        mSelectText.setOnClickListener(){
//            ClassAlertList().show(childFragmentManager,"classAlert")
//        }

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
