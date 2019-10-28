package com.example.phonebook.Fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.phonebook.R
import com.example.phonebook.activity.DetailActivity
import com.example.phonebook.adapter.ContactAdapter
import kotlinx.android.synthetic.main.fragment_contact.*

/**
 * A simple [Fragment] subclass.
 */
class ContactFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecycleView()
        initEvent()
    }

    private fun initRecycleView() {

    }

    private fun initEvent() {
        fabAdd.setOnClickListener {
            startActivity(Intent(activity!!, DetailActivity::class.java))
        }
    }


}
