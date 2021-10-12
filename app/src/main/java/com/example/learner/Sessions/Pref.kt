package com.example.learner.Sessions

import android.content.Context
import android.content.SharedPreferences

class Pref(context: Context) {
    private val dataName = "getSharedData"
    private val preference:SharedPreferences = context.getSharedPreferences(dataName,Context.MODE_PRIVATE)

     fun getSession(key: String, value: String, context: Context) {
        val sharedPreferencesName = "learnersharepref"
        val preferences = context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putString(key,value)
        editor.apply()
    }

}