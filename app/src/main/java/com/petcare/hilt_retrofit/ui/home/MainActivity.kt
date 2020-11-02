package com.petcare.hilt_retrofit.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.petcare.hilt_retrofit.R
import com.petcare.hilt_retrofit.model.AlbumItem
import com.petcare.hilt_retrofit.model.Albums
import com.petcare.hilt_retrofit.network.AlbumService
import com.petcare.hilt_retrofit.network.RetrofitInstance
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofitSetvice =
            RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)

        val resonseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retrofitSetvice.getAlbum()
            emit(response)
        }


        val resonseLiveData2: LiveData<Response<Albums>> = liveData {
            val response2 = retrofitSetvice.getSortedAlbum(4)
            emit(response2)
        }

        resonseLiveData2.observe(this, Observer {
            val albumList = it.body()?.listIterator()
            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumItem = albumList.next()
                    Log.e(TAG, "onCreate: " + albumItem.toString())
                }
            }
        })




//        resonseLiveData.observe(this, Observer {
//            val albumList = it.body()?.listIterator()
//            if (albumList != null) {
//                while (albumList.hasNext()) {
//                    val albumItem = albumList.next()
//                    Log.e(TAG, "onCreate: " + albumItem.toString())
//                }
//            }
//        })


    }
}