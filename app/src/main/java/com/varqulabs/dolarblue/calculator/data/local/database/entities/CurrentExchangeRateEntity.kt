package com.varqulabs.dolarblue.calculator.data.local.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.varqulabs.dolarblue.history.domain.model.CurrentExchangeRate
import java.time.LocalDateTime

@Entity(tableName = "current_exchange_rate_table")
data class CurrentExchangeRateEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "pesosBob") val pesosBob: String,
    @ColumnInfo(name = "pesosArg") val pesosArg: String,
    @ColumnInfo(name = "date") val date: LocalDateTime,
)

fun CurrentExchangeRateEntity.mapToModel() = CurrentExchangeRate(
    id = id,
    pesosBob = pesosBob,
    pesosArg = pesosArg,
    date = date
)