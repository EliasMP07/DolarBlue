package com.varqulabs.dolarblue.history.data.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.RawQuery
import androidx.room.Transaction
import androidx.sqlite.db.SupportSQLiteQuery
import com.varqulabs.dolarblue.history.data.local.database.entities.relations.ConversionsHistoryRelation
import com.varqulabs.dolarblue.history.data.local.database.entities.relations.ConversionsWithCurrentExchangeRelation
import kotlinx.coroutines.flow.Flow

@Dao
interface ConversionsHistoryDao {

    @Transaction
    @Query("SELECT * FROM current_exchange_rate_table")
    fun getConversionsHistoryFlow(): Flow<List<ConversionsHistoryRelation>>

    @Transaction
    @Query("SELECT * FROM current_exchange_rate_table")
    fun getConversionsHistory(): List<ConversionsHistoryRelation>

    @Query("UPDATE conversion_table SET isFavorite = :isFavorite WHERE id = :conversionId")
    fun addConversionFavorite(conversionId: Int, isFavorite: Boolean)

    @Transaction
    @Query("""
        SELECT * FROM current_exchange_rate_table 
        JOIN conversion_table ON current_exchange_rate_table.id = conversion_table.currentExchangeId 
        WHERE conversion_table.isFavorite = 1
    """)
    fun getFavoriteConversionsHistory(): Flow<List<ConversionsWithCurrentExchangeRelation>>

    @Transaction
    @RawQuery
    fun searchConversionsHistoryByQuery(query: SupportSQLiteQuery): Flow<List<ConversionsWithCurrentExchangeRelation>>
}