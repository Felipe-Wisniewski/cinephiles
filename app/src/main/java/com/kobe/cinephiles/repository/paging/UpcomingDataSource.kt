package com.kobe.cinephiles.repository.paging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.kobe.cinephiles.model.UpcomingMovie
import com.kobe.cinephiles.model.UpcomingResults
import com.kobe.cinephiles.repository.retrofit.HttpService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingDataSource(private val service: HttpService) : PageKeyedDataSource<Int, UpcomingMovie>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, UpcomingMovie>) {
        createPaging(1, 2, callback, null)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UpcomingMovie>) {
        val page = params.key
        createPaging(page, page + 1, null, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UpcomingMovie>) {
        val page = params.key
        createPaging(page, page - 1, null, callback)
    }

    private fun createPaging(requestPage: Int,
                             adjacentPage: Int,
                             initialCallback: LoadInitialCallback<Int, UpcomingMovie>?,
                             callback: LoadCallback<Int, UpcomingMovie>?) {

        service.upcomingMovies(requestPage).enqueue(object : Callback<UpcomingResults> {

            override fun onResponse(call: Call<UpcomingResults>, response: Response<UpcomingResults>) {

                if (response.body()?.results != null) {
                    initialCallback?.onResult(response.body()!!.results, null, adjacentPage)
                    callback?.onResult(response.body()!!.results, adjacentPage)
                }

            }

            override fun onFailure(call: Call<UpcomingResults>, t: Throwable) {
                Log.d("FLMWG", "onFailure upcomingMovies", t)
            }
        })
    }
}