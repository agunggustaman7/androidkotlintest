package com.example.phonebook.adapter


import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.phonebook.R
import com.example.phonebook.data.ContactData
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter() : RecyclerView.Adapter<ContactAdapter.ViewHolder>(){

    var arrayList : ArrayList<ContactData> = ArrayList()

    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view){
        fun binData (contactData: ContactData){
            Glide.with(view).load(contactData.image_url).apply(RequestOptions().circleCrop()).into(view.fotobook)


            view.tvNama.text = contactData.name
            view.tvPhone.text = contactData.phone


        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(arrayList[position])
    }




}