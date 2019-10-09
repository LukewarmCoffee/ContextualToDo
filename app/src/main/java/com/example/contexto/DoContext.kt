package com.example.contexto
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "do_table")
class DoContext(@PrimaryKey @ColumnInfo(name = "title")  val title: String, val contexto: String, val timeExpected: String)