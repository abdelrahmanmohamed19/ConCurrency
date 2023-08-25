package com.example.concurrency.data.repository

import com.example.concurrency.data.remote.ApiServices
import com.example.concurrency.domain.repository.CompareRepository
import javax.inject.Inject

class CompareRepositoryImpl @Inject constructor(private val api : ApiServices) : CompareRepository {
}