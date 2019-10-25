package com.example.phonebook


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_contact.*

/**
 * A simple [Fragment] subclass.
 */
class FragmentContact : Fragment() {
    companion object{
        fun getInstance(): FragmentContact = FragmentContact()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_contact, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecyclerView()

    }


    private fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(activity!!)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        //Setting atribute rvArrayList
        rvArrayList.apply {
            setHasFixedSize(true)
            adapter = postAdapter
            layoutManager = linearLayoutManager
        }
    }
    }



