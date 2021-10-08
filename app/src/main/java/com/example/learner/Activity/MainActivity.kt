package com.example.learner.Activity

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.learner.Fragments.HomeFragment
import com.example.learner.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_fragments)
        firstLayout(HomeFragment.getInstance(), this)
//            secondLayout(SecondFragment.getSecondInstance(),this)
    }

    //Call toast message..
    private fun toast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }


    //recreate fragment manager for firstLayout
    private fun firstLayout(fragment: Fragment, context: Context) {
        val recreateFragment = supportFragmentManager
        val fragmentTransaction = recreateFragment.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment)
        fragmentTransaction.commit()

    }
}

