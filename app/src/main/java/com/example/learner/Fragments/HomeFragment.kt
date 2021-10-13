package com.example.learner.Fragments

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learner.R
import com.example.learner.util.AppConstants
import com.example.learner.util.AppSessions
import com.google.gson.Gson

internal val TAG = HomeFragment::class.java.canonicalName

class HomeFragment : Fragment() {
    private lateinit var viewFragment: View
    private lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: Adapter
    private lateinit var progressBar: ProgressBar
    private lateinit var searchView: EditText
    private lateinit var logoutButton:Button
    private val data = ArrayList<TrendingRepo>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        viewFragment = inflater.inflate(R.layout.home_fragment, container, false)
        validation()
        return viewFragment
    }

    private fun validation() {
        recyclerView = viewFragment.findViewById(R.id.recyclerView)
        searchView = viewFragment.findViewById(R.id.searchView)
        logoutButton = viewFragment.findViewById(R.id.logoutBtn)
        searchView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(searchText: Editable) {
                if (searchText.isEmpty()) {
                    callGson()
                } else {
                    searchFilter(searchText.toString())
                }
            }

        })

        logoutButton.setOnClickListener(){
            if (isLogout()){
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView2, LoginFragment.getInstance())
                    .commit()
            }

        }

        customAdapter = Adapter(data, requireContext())
        recyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = customAdapter
        }
        callGson()
    }

    private fun searchFilter(toString: String) {
        val trendingRepoList: TrendingRepoModal? = Gson().fromJson(
            AppConstants.SAMPLE_DATA,
            TrendingRepoModal::class.java
        )
        val filterData = trendingRepoList!!.responseData.filter {
            it.author.contains(toString, ignoreCase = true)
        }
        customAdapter.resetview(filterData)
    }

    private fun callGson() {
        val trendingRepoList = Gson().fromJson(
            AppConstants.SAMPLE_DATA,
            TrendingRepoModal::class.java
        )

        Log.i(TAG, "callGson: trendingRepoList -> $trendingRepoList")

        trendingRepoList.responseData.let {
            customAdapter.resetview(it)
        }

    }

    override fun onStart() {
        super.onStart()
        progressBar = viewFragment.findViewById(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
        Handler().postDelayed(
            Runnable {
                progressBar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                logoutButton.visibility = View.VISIBLE
            },
            2000
        )
    }


    private fun isLogout():Boolean{
        AppSessions.removeSession(requireContext())
        return true
    }

    companion object {
        fun getInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}