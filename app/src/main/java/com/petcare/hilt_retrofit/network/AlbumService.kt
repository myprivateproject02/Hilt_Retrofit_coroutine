package com.petcare.hilt_retrofit.network

import com.petcare.hilt_retrofit.model.AlbumItem
import com.petcare.hilt_retrofit.model.Albums
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {


    //    https://jsonplaceholder.typicode.com/albums
    @GET("/albums")
    suspend fun getAlbum(): Response<Albums>


    @GET("/albums")
    suspend fun getSortedAlbum(@Query("userId") userId: Int): Response<Albums>


}