package com.example.screenorientation.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.screenorientation.R
import com.google.gson.Gson

internal val TAG = ClassFragments::class.java.canonicalName

class ClassFragments : Fragment() {
    private lateinit var viewFragment: View
    lateinit var createOne: TextView
    lateinit var recylerView: RecyclerView
    lateinit var customAdapter: CustomAdapter
    lateinit var imageView: ImageView
    lateinit var textView: TextView
    private val data = ArrayList<ItemViewModel>()
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

    private fun toast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    private fun validation() {
        recylerView = viewFragment.findViewById(R.id.recyclerView)

        val customAdapter = CustomAdapter(data)
        recylerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = customAdapter
        }
        callGson()

    }
    private fun validationInfo(validation:Array<EditText>):Boolean{
        var flag = true
        for(item in validation){
            if(item.text.toString().isEmpty()){
                item.error = "field required"
                flag = false
            }
        }
        return flag
    }
    private fun callGson(){
        val gSon = Gson().fromJson<ItemViewModel>("",ItemViewModel::class.java)
        
    }


}