package com.example.screenorientation.Activity

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.screenorientation.FragmentClass.ClassFragments
import com.example.screenorientation.FragmentClass.SecondFragment
import com.example.screenorientation.R
import android.content.res.Configuration.ORIENTATION_PORTRAIT as ORIENTATION_PORTRAIT1

class SetFragments : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_fragments)

        val config = Configuration()

        Log.i("Main Activity", "onCreate: config --> P/${Configuration.ORIENTATION_PORTRAIT}")
        Log.i("Main Activity", "onCreate: config --> L/${Configuration.ORIENTATION_LANDSCAPE}")
        Log.i("Main Activity", "onCreate: config --> ${config.orientation}")

        if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {

            Log.i("Main Activity", "onCreate: ORIENTATION_PORTRAIT")
            firstLayout(ClassFragments.getInstance(), this)
        }
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            Log.i("Main Activity", "onCreate: ORIENTATION_LANDSCAPE")

            secondLayout(SecondFragment.getSecondInstance(), this)
        }

    }

    //change configuration to check landscape and portrait
    override fun onConfigurationChanged(config: Configuration) {
        super.onConfigurationChanged(config)

        if (config.orientation == ORIENTATION_PORTRAIT1) {
            Log.i("Main Activity", "onCreate: config --> ${config.orientation}")
            firstLayout(ClassFragments.getInstance(), this)
        }

        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.i("Main Activity", "onCreate: config --> ${config.orientation}")
            secondLayout(SecondFragment.getSecondInstance(), this)
        }
    }

    private fun firsFragmentCall(fragment: Fragment) {

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






