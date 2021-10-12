package com.example.learner.util

import android.content.Context
import android.content.SharedPreferences

object AppSessions {

    fun setSession(key: String, value: String, context: Context) {
        val preferences =
            context.getSharedPreferences(AppConstants.Preference.PREFERENCE, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun setFirstName(key: String, value: String, context: Context) {
        val preferences =
            context.getSharedPreferences(AppConstants.Preference.PREFERENCE, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
    fun setLastName(key: String, value: String, context: Context) {
        val preferences =
            context.getSharedPreferences(AppConstants.Preference.PREFERENCE, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
    fun setMobilenumber(key: String, value: String, context: Context) {
        val preferences =
            context.getSharedPreferences(AppConstants.Preference.PREFERENCE, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
    fun setConfirmpassword(key: String, value: String, context: Context) {
        val preferences =
            context.getSharedPreferences(AppConstants.Preference.PREFERENCE, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putString(key, value)
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


}

