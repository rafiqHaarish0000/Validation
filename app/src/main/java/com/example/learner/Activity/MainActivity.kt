package com.example.learner.Activity

import android.content.Context
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.example.learner.Fragments.LoginFragment
import com.example.learner.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_fragments)
        firstLayout(LoginFragment.getInstance(), this)
    }

    //recreate fragment manager for firstLayout
    private fun firstLayout(fragment: Fragment, context: Context) {
        val recreateFragment = supportFragmentManager
        val fragmentTransaction = recreateFragment.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment)
        fragmentTransaction.commit()

    }
}

