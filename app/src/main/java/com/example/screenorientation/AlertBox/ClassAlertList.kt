package com.example.screenorientation.AlertBox

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.screenorientation.R




class ClassAlertList : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val v: View = requireActivity().layoutInflater.inflate(R.layout.alert_show, null)
        val arrayList: ArrayList<String> = arrayListOf("Africa", "Burma", "China","Malaysia")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, arrayList)
        val mList = v.findViewById<ListView>(R.id.listview)
        mList.adapter = adapter
        val dialog = AlertDialog.Builder(requireContext())
            .setView(v)
            .create()
        return dialog
    }

    companion object {
        const val TAG = "classAlert"
    }
}

