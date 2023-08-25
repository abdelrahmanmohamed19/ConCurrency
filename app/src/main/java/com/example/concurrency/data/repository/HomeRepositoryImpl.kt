package com.example.concurrency.data.repository

import com.example.concurrency.data.remote.ApiServices
import com.example.concurrency.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val api : ApiServices): HomeRepository {
}