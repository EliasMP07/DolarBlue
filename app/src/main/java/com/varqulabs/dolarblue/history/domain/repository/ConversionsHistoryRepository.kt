package com.varqulabs.dolarblue.history.domain.repository

import com.varqulabs.dolarblue.history.domain.model.Conversion
import com.varqulabs.dolarblue.history.domain.model.QueryAndCurrency
import com.varqulabs.dolarblue.history.domain.model.ConversionsHistory
import kotlinx.coroutines.flow.Flow

interface ConversionsHistoryRepository {

    suspend fun getConversionsHistoryFlow(): Flow<List<ConversionsHistory>>

    suspend fun getFavoriteConversionsHistory(): Flow<List<ConversionsHistory>>

    suspend fun updateConversion(conversion: Conversion)

    suspend fun deleteConversion(conversion: Conversion)

    suspend fun searchConversionsHistoryByQueryAndCurrency(queryAndCurrency: QueryAndCurrency): Flow<List<ConversionsHistory>>
}