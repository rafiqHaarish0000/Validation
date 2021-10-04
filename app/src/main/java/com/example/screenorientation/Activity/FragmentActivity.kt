package com.example.screenorientation.Activity

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.screenorientation.Fragments.ClassFragments
import com.example.screenorientation.Fragments.SecondFragment
import com.example.screenorientation.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_fragments)
        firstLayout(ClassFragments.getInstance(), this)
//            secondLayout(SecondFragment.getSecondInstance(),this)
    }

    //Call toast message..
    private fun toast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    //recreate fragment manager for second layout
    private fun secondLayout(fragment: Fragment, context: Context) {
        val recreateManager = supportFragmentManager
        val fragmentTransaction = recreateManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment)
        fragmentTransaction.commit()
    }

    //recreate fragment manager for firstlayout
    private fun firstLayout(fragment: Fragment, context: Context) {
        val recreateFragment = supportFragmentManager
        val fragmentTransaction = recreateFragment.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment)
        fragmentTransaction.commit()

    }

    companion object {
        private var res: Boolean = false
    }

}

