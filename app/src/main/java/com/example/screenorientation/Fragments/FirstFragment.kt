package com.example.screenorientation.Fragments

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.screenorientation.R
import com.example.screenorientation.util.AppConstants
import com.google.gson.Gson
import android.graphics.drawable.GradientDrawable

import android.graphics.drawable.Drawable
internal val TAG = ClassFragments::class.java.canonicalName

class ClassFragments : Fragment() {
    private lateinit var viewFragment: View
    lateinit var createOne: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var customAdapter: CustomAdapter
    lateinit var imageView: ImageView
    lateinit var textView: TextView
    lateinit var progressBar: ProgressBar
    private val data = ArrayList<TrendingRepo>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        viewFragment = inflater.inflate(R.layout.first_fragment, container, false)
        validation()
        return viewFragment
    }
    companion object {
        fun getInstance(): ClassFragments {
            return ClassFragments()
        }
    }
    private fun validation() {
        recyclerView = viewFragment.findViewById(R.id.recyclerView)
        customAdapter = CustomAdapter(data, requireContext())
        recyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = customAdapter
        }
        callGson()
    }

    private fun validationInfo(validation: Array<EditText>): Boolean {
        var flag = true
        for (item in validation) {
            if (item.text.toString().isEmpty()) {
                item.error = "field required"
                flag = false
            }
        }
        return flag
    }

    private fun callGson() {
        val trendingRepoList = Gson().fromJson(
            AppConstants.SAMPLE_DATA,
            TrendingRepoModal::class.java
        )

        Log.i(TAG, "callGson: trendingRepoList -> $trendingRepoList")

        trendingRepoList.responseData.let{
            customAdapter.updateDataset(it)

        }
    }


    override fun onStart() {
        super.onStart()
        val progressBar = viewFragment.findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        Handler().postDelayed(
            Runnable { progressBar.visibility = View.GONE
                     recyclerView.visibility = View.VISIBLE},
            2000
        )
    }


}