package com.adityaa0108.newsapp

import android.content.Context
import android.net.DnsResolver
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import retrofit2.Call
import retrofit2.Response

import retrofit2.Callback

@Suppress("UNREACHABLE_CODE")
class HomeFragment : Fragment() {

    var api:String = "bc8f9c0d15fc44bc9005d560bfc7d5e2"
    lateinit var list :ArrayList<ModelClass>

    lateinit var adapterr : Adapter
    var country:String = "in"


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.homefragment,container,false)
       val recyclerView = view?.findViewById<RecyclerView>(R.id.recycleviewofhome)
        list = ArrayList()
        recyclerView?.layoutManager = LinearLayoutManager(context)
        adapterr =  Adapter(requireContext(),list)
        recyclerView?.adapter = adapterr
        findNews()
        return view

    }

      fun findNews(){
           RetrofitInstance.apiInterface.getNews(country,100,api).enqueue(object : Callback<MainNews> {
                  override fun onResponse(call : Call<MainNews>,response: Response<MainNews>){
                              if(response.isSuccessful()){
                                  var data = response.body()!!.articles
                                  if (data != null) {
                                      list.addAll(data)
                                  }
                                  adapterr.notifyDataSetChanged()
                              }
               
           }
               override fun onFailure(call : Call<MainNews>,t:Throwable){


               }

           })

      }

}