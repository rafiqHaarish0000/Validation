package com.example.screenorientation.Activity

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import com.example.screenorientation.R
import android.view.LayoutInflater
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private val TAG = MainActivity2::class.java.canonicalName
    private var alertDialogButton: Button? = null
    var name: String? = null
    private var view1: View? = null
    private lateinit var ed:EditText
    var dialog: AlertDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        alertDialogButton = findViewById<View>(R.id.alert) as Button
        dialog = AlertDialog.Builder(this).create()
        view1 = LayoutInflater.from(this).inflate(R.layout.bottom_btn, null)

        ed = view1!!.findViewById(R.id.show)
        name = ed.text.toString()
        alertDialogButton!!.setOnClickListener(this)


        if (savedInstanceState != null) {
            name = savedInstanceState.getString("name")
            ed.setText(name)
            var auth = dialog!!.onSaveInstanceState().getBoolean("alert")
            if (alert.also { auth = it }) {
                alertDialog()
            }
        }
    }

    //button on click..
    override fun onClick(view: View) {
        when (view.id) {
            R.id.alert -> if (true.also { alert = it }) {
                alertDialog()
            }

        }
    }

    //onStop()
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val userName = ed.text.toString()
        outState.putString("name", userName)
        outState.putBoolean("alert", alert)
    }

    //show alert
    fun alertDialog() {
        dialog!!.setTitle("Alert")
        dialog!!.setMessage("Rotate your screen")
        dialog!!.setView(view1)
        dialog!!.setCancelable(true)
        dialog!!.setOnCancelListener {
            Log.i(TAG, "onCancel: alert -> " + alert)
            alert = false
            Log.i(TAG, "onCancel: alert -> " + alert)
        }
        dialog!!.show()
    }

    //toast message if needed..
    private fun toast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private var alert = false
    }
}