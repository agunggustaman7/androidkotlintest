package com.example.phonebook.Fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.biceps_studio.task_layout.api.API
import com.example.phonebook.BuildConfig

import com.example.phonebook.R
import com.example.phonebook.activity.DetailActivity
import com.example.phonebook.adapter.ContactAdapter
import com.example.phonebook.data.ResponseData
import com.example.phonebook.helper.Utils
import kotlinx.android.synthetic.main.fragment_contact.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class ContactFragment : Fragment() {

    val contactAdapter = ContactAdapter()

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

    override fun onResume() {
        super.onResume()
        getData()
    }

    private fun getData() {
        srlMain.isRefreshing = true
        API.getContacts(object : Callback<ResponseData>{
            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                srlMain.isRefreshing = false

                if (BuildConfig.DEBUG){
                    Utils.showToast(activity!!, t.message!!)
                }

            }

            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                srlMain.isRefreshing = false
                if(response.isSuccessful) {
                    contactAdapter.arrayList = response.body()!!.data
                    contactAdapter.notifyDataSetChanged()

                }else{

                    if (BuildConfig.DEBUG){
                        Utils.showToast(activity!!, response.message())
                    }
                }
            }
        })
    }


    private fun initRecycleView() {
        val linearLayoutManager = LinearLayoutManager(activity!!)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        rvContact.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = contactAdapter

        }
    }

    private fun initEvent() {
        fabAdd.setOnClickListener {
            startActivity(Intent(activity!!, DetailActivity::class.java))

            srlMain.setOnRefreshListener { getData() }
        }
    }


}
