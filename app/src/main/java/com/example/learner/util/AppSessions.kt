package com.example.learner.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import com.example.learner.Fragments.HomeFragment
import com.example.learner.R

object AppSessions {

    fun setSession(key: String, value: String, context: Context) {
        val preferences =
            context.getSharedPreferences(AppConstants.Preference.PREFERENCE, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun removeSession(context: Context) {
        val preferences =
            context.getSharedPreferences(AppConstants.Preference.PREFERENCE, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.clear().apply()
    }

    fun setSession(key: String, value: Boolean, context: Context) {
        val preferences =
            context.getSharedPreferences(AppConstants.Preference.PREFERENCE, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }
    fun getSession(key: String, default: String, context: Context): String {
        val preferences =
            context.getSharedPreferences(AppConstants.Preference.PREFERENCE, Context.MODE_PRIVATE)
        return preferences.getString(key, default)!!
    }

    fun getSession(key: String, context: Context): String {
        val preferences =
            context.getSharedPreferences(AppConstants.Preference.PREFERENCE, Context.MODE_PRIVATE)
        return preferences.getString(key, "")!!
    }

    fun getSession(key: String, default:Boolean,context: Context):Boolean{
        val preferences =
            context.getSharedPreferences(AppConstants.Preference.PREFERENCE, Context.MODE_PRIVATE)
        return preferences.getBoolean(key,default)
    }

}


