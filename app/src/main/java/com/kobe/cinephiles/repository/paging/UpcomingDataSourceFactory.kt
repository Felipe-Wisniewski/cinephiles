package com.kobe.cinephiles.repository.paging

import androidx.paging.DataSource
import com.kobe.cinephiles.model.UpcomingMovie
import com.kobe.cinephiles.repository.retrofit.HttpService

class UpcomingDataSourceFactory(private val service: HttpService) : DataSource.Factory<Int, UpcomingMovie>() {

    override fun create(): DataSource<Int, UpcomingMovie> {
        return UpcomingDataSource(service)
    }

}