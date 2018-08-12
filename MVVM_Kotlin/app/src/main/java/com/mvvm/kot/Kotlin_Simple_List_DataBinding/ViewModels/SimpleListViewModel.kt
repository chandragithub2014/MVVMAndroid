package com.mvvm.kot.Kotlin_Simple_List_DataBinding.ViewModels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.mvvm.kot.Kotlin_Retrofit_Room_Data_Binding.Repository.ResultModel
import com.mvvm.kot.R
import java.util.ArrayList

class SimpleListViewModel : AndroidViewModel {
    private  var mAllLists: LiveData<List<SimpleListDTO>>
    constructor(application: Application) : super(application){
        mAllLists = getSimpleListData()
    }


    fun getSimpleListData(): LiveData<List<SimpleListDTO>> {
        val dataList = ArrayList<SimpleListDTO>()
        val images = intArrayOf(R.drawable.ic_india_flag, R.drawable.ic_brazil_flag, R.drawable.ic_eeuu_flags, R.drawable.ic_iran_flag, R.drawable.ic_malaysia_flag, R.drawable.ic_netherlands_flag, R.drawable.ic_romania_flag, R.drawable.ic_turkey_flag, R.drawable.ic_united_kingdom_flag, R.drawable.ic_uzbekistan_flag)
        val titles = arrayOf("India", "Brazil", "EEUU", "Iran", "Malaysia", "NetherLands", "Romania", "Turkey", "UK", "Uzebkistan")

        var i = 0
        while (i < titles.size && i < images.size) {
            val temp = SimpleListDTO(titles[i],images[i])
            /*temp.iconId = images[i]
            temp.title = titles[i]*/
            dataList.add(temp)
            i++

        }
        val data = MutableLiveData<List<SimpleListDTO>>()
        data.value = dataList
        return data
    }

}