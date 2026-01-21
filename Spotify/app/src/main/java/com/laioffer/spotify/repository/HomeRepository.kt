package com.laioffer.spotify.repository

import android.util.Log
import com.laioffer.spotify.datamodel.Section
import com.laioffer.spotify.network.NetworkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject


class HomeRepository @Inject constructor(
    private val networkApi: NetworkApi
) {

    suspend fun getHomeSections(): List<Section> = withContext(Dispatchers.IO){
            val responseCall: Call<List<Section>> = networkApi.getHomeFeed()
            val response: Response<List<Section>> = responseCall.execute()
            val sections: List<Section>? = response.body()
            sections ?: listOf()
    }
}