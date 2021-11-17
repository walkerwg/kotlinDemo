package com.example.myapplication.test.weatherMVVM

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.myapplication.R

class WeatherFragment : Fragment() {

    private val TAG = WeatherFragment::class.qualifiedName

    companion object {
        fun newInstance() = WeatherFragment()
    }

    private lateinit var viewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        viewModel.list?.observe(viewLifecycleOwner, Observer {
           Log.i(TAG, it.toString())
            val textView = view?.findViewById(R.id.textView2) as  TextView
            textView.text = it.tempture

            val textView3 = view?.findViewById(R.id.textView3) as  TextView
            textView3.text = it.dampness.toString()
        })
    }

}