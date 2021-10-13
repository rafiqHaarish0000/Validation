package com.example.learner.Activity

import android.content.Context
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.learner.Fragments.HomeFragment

import com.example.learner.Fragments.LoginFragment
import com.example.learner.R
import com.example.learner.util.AppConstants
import com.example.learner.util.AppSessions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_fragments)
        isLoggedIn()
    }

    //recreate fragment manager for firstLayout
    private fun isLoggedIn() {
        val isLoggedIn = AppSessions.getSession(AppConstants.Preference.Key.IS_LOGGED_IN,default = false,this)
        if(isLoggedIn){
            loadFragment(HomeFragment.getInstance(),this)
        }else{
            loadFragment(LoginFragment.getInstance(),this)
        }
    }

    private fun loadFragment(fragment: Fragment, context: Context) {
        val recreateFragment = supportFragmentManager
        val fragmentTransaction = recreateFragment.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment)
        fragmentTransaction.commit()

    }

  }

