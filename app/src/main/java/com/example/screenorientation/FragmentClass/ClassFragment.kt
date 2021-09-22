package com.example.screenorientation.FragmentClass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.screenorientation.R

class ClassFragments : Fragment(), View.OnClickListener {
    private var alertButton: Button? = null
    private lateinit var alertDialogCheck: AlertDialog
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        var view = inflater.inflate(R.layout.fragment_layout, container, false)
        alertButton = view.findViewById(R.id.button)
        alertDialogCheck = AlertDialog.Builder(requireContext()).apply {
            setTitle("Alert")
            setMessage("Rotate your screen")
        }.create()
        alertButton!!.setOnClickListener(this)
        return view
    }

    companion object {
        private var check = false
        fun getInstance(): ClassFragments {
            return ClassFragments()
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.button -> if (true.also { check = it }) {
                showAlert()
            }
        }
    }

    private fun showAlert() {
        alertDialogCheck.show()
    }




}