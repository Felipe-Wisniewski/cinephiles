package com.kobe.cinephiles

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.kobe.cinephiles.model.UpcomingMovie
import com.kobe.cinephiles.repository.MovieRepository
import com.kobe.cinephiles.repository.paging.UpcomingDataSource
import com.kobe.cinephiles.repository.paging.UpcomingDataSourceFactory
import com.kobe.cinephiles.view.upcoming.UpcomingViewModel
import com.nhaarman.mockitokotlin2.mock
import org.junit.Before
import org.junit.Rule
import java.util.*

class UpcomingViewModelTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: UpcomingViewModel
    private val mockedRepo = mock<MovieRepository>()
    private val mockedDataSource = mock<UpcomingDataSourceFactory>()

    private val anMovieId = Random().nextInt()
    private val anMovie = UpcomingMovie(id = anMovieId, title = "The Kobe", poster_path = "https://",
        genre_ids = emptyList(), vote_average = 7.1f, release_date = "2020/03/18")

    @Before
    fun before_each_test() {
        viewModel = UpcomingViewModel(mockedRepo, mockedDataSource)
    }
}