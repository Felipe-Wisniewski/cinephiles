package com.kobe.cinephiles.di

import com.kobe.cinephiles.repository.MovieRepositoryImpl
import com.kobe.cinephiles.repository.paging.UpcomingDataSourceFactory
import com.kobe.cinephiles.repository.retrofit.HttpServiceImpl
import com.kobe.cinephiles.ui.upcoming.UpcomingViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        val retrofit = HttpServiceImpl.getService()
        MovieRepositoryImpl(service = retrofit)
    }

    viewModel {
        UpcomingViewModel(repository = get(), sourceFactory = get())
    }

    factory {
        val retrofit = HttpServiceImpl.getService()
        UpcomingDataSourceFactory(service = retrofit)
    }

}