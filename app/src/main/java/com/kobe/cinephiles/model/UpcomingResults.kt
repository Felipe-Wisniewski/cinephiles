package com.kobe.cinephiles.model

data class UpcomingResults(val results: List<UpcomingMovie>,
                           val page: Int,
                           val total_results: Int,
                           val total_pages: Int)